package com.recipe.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.recipe.models.Recipe;
import com.recipe.models.User;
import com.recipe.s3.S3Config;
import com.recipe.services.UserService;
import com.recipe.validator.UserValidator;

@Controller
public class Users {
	private UserService userService;
	private UserValidator userValidator;

	public Users(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	@GetMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}

	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		// NEW
		userValidator.validate(user, result);

		if (result.hasErrors()) {
			return "registrationPage.jsp";
		}

		// change add admin role
//        userService.saveUserWithAdminRole(user);

		userService.saveWithUserRole(user);

		return "redirect:/";
	}

	@GetMapping("/admin")
	public String adminPage(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));
		return "adminPage.jsp";
	}

	// 1
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
		return "loginPage.jsp";
	}

	@GetMapping(value = { "/", "/home" })
	public String home(Principal principal, Model model, HttpSession session) throws UnirestException {
		// 1
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		Long userId = currentUser.getId();
		List<Recipe> allRecipes = this.userService.getAllRecipes();
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("allRecipes", allRecipes);

		session.setAttribute("userId", userId);

		HttpResponse<String> response1 = Unirest
				.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/jokes/random")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.header("x-rapidapi-key", "3a01be6e25msh75a6c8a146c41d5p18acf7jsn5846c5ec8a46").asString();
		Gson gson1 = new Gson();
		JsonObject jsonObject1 = gson1.fromJson(response1.getBody(), JsonObject.class);
//		System.out.println(jsonObject1.get("text").getAsString());
		model.addAttribute("joke1", jsonObject1.get("text").getAsString());

		HttpResponse<String> response2 = Unirest
				.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/jokes/random")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.header("x-rapidapi-key", "3a01be6e25msh75a6c8a146c41d5p18acf7jsn5846c5ec8a46").asString();
//		System.out.println("response2: " + response2.getBody());
//		System.out.println("response2: " + response2.toString());
		Gson gson2 = new Gson();
		JsonObject jsonObject2 = gson2.fromJson(response2.getBody(), JsonObject.class);
//		System.out.println(jsonObject2.get("text").getAsString());
		model.addAttribute("joke2", jsonObject2.get("text").getAsString());

		HttpResponse<String> response3 = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?number=9&tags=vegetarian%252Cdessert")
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.header("x-rapidapi-key", "3a01be6e25msh75a6c8a146c41d5p18acf7jsn5846c5ec8a46")
				.asString();
		Gson gson3 = new Gson();
		JsonObject jsonObject3 = gson3.fromJson(response3.getBody(), JsonObject.class);
		
		JsonArray array = jsonObject3.get("recipes").getAsJsonArray();
//		System.out.println("response3: " + response3.getBody());
		List listIds = new ArrayList();
		List listTitles = new ArrayList();
		List listImages = new ArrayList();
		List listSourceUrls = new ArrayList();
		List listPricePerServings = new ArrayList();

		for (JsonElement a : array) {
//			System.out.println("a.title:" + a.getAsJsonObject().get("title").getAsString());
			listIds.add(a.getAsJsonObject().get("id").getAsString());
			listTitles.add(a.getAsJsonObject().get("title").getAsString());
			listImages.add(a.getAsJsonObject().get("image").getAsString());
			listSourceUrls.add(a.getAsJsonObject().get("sourceUrl").getAsString());
			listPricePerServings.add(a.getAsJsonObject().get("pricePerServing").getAsDouble());
			
		}

		model.addAttribute("listIds", listIds);
		model.addAttribute("listTitles", listTitles);
		model.addAttribute("listImages", listImages);
		model.addAttribute("listSourceUrls", listSourceUrls);
//		System.out.println("listPricePerServings:" + listPricePerServings);
//		System.out.println("listTitles:" + listTitles);

		return "index.jsp";
	}

	@GetMapping("/recipe/new")
	public String newRecipe(@Valid @ModelAttribute("recipeObj") Recipe recipeObj, Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));

		return "newrecipe.jsp";
	}

	@PostMapping("/recipe/new")
	public String createRecipe(@Valid @ModelAttribute("recipeObj") Recipe recipeObj, Model model, BindingResult result,
			Principal principal,@RequestParam("image")MultipartFile image) throws IOException {
		System.out.println(image.toString());
		
		S3Config.uploadImage("scallopsrecipe", image.getOriginalFilename(), image.getInputStream());
		String imageUrl="https://scallopsrecipe.s3.amazonaws.com/" +image.getOriginalFilename();
		
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);

		if (result.hasErrors()) {
			return "newrecipe.jsp";
		}
//        User user = this.userService.findByUsername(username);
		recipeObj.setImageUrl(imageUrl);
		userService.createNewRecipe(recipeObj, currentUser);
		System.out.println("You created a new recipe!!!");
		return "redirect:/";
	}

	@GetMapping("recipes/{recipeId}")
	public String displayRecipe(@PathVariable("recipeId") Long recipeId, Model model) throws UnirestException {
		
		Recipe r = this.userService.getRecipeById(recipeId);
		HttpResponse<String> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/"+recipeId+"/information")
//		HttpResponse<String> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/recipe?id="+recipeId)
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.header("x-rapidapi-key", "3a01be6e25msh75a6c8a146c41d5p18acf7jsn5846c5ec8a46")
				.asString();
		
		Gson gson = new Gson();
//		JsonArray jsonArray = gson.fromJson(response.getBody(), JsonArray.class);
//		System.out.println("************************");
//		System.out.println("recipe is: "+jsonArray);
//		System.out.println("************************");
		JsonObject jsonObject = gson.fromJson(response.getBody(), JsonObject.class);
		System.out.println("************************");
		System.out.println(recipeId);
		System.out.println("recipe is: "+jsonObject);
		System.out.println("************************");
		
		String title = jsonObject.get("title").getAsString();
		String image = jsonObject.get("image").getAsString();
		JsonArray extendedIngredients = jsonObject.get("extendedIngredients").getAsJsonArray();
		String instructions = jsonObject.get("instructions").getAsString();
		System.out.println("recipe Title is: "+title);
		System.out.println("recipe extendedIngredients is: "+extendedIngredients);
		System.out.println("recipe instructions is: "+instructions);
		model.addAttribute("recipeId", recipeId);
		model.addAttribute("title", title);
		model.addAttribute("image", image);
		model.addAttribute("extendedIngredients", extendedIngredients);
		model.addAttribute("instructions", instructions);
		model.addAttribute("r", r);
		return "displayRecipe.jsp";
	}

	@GetMapping("recipes/{recipeId}/edit")
	public String displayEditRecipe(@PathVariable("recipeId") Long recipeId, Model model,
			@Valid @ModelAttribute("recipeObj") Recipe recipeObj) {
		Recipe r = this.userService.getRecipeById(recipeId);
		model.addAttribute("r", r);
		return "editRecipe.jsp";
	}

	@PutMapping("recipes/{recipeId}/edit")
	public String editRecipe(@PathVariable("recipeId") Long recipeId, Model model,
			@Valid @ModelAttribute("recipeObj") Recipe recipeObj, BindingResult result, Principal principal) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		if (result.hasErrors()) {
			return "editRecipe.jsp";
		}
		userService.createNewRecipe(recipeObj, currentUser);
		System.out.println(recipeObj.getName());
		System.out.println("recipe id: " + recipeObj.getId());
		System.out.println("You edit a new recipe!!!");
		return "redirect:/recipes/{recipeId}";
	}

//    @RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.DELETE)
	@DeleteMapping("/recipes/{recipeId}")
	public String destroy(@PathVariable("recipeId") Long recipeId) {
		this.userService.deleteRecipe(recipeId);
		System.out.println("You delete a recipe");
		return "redirect:/";
	}

	@GetMapping("/recipes/{recipeId}/ingredients")
	public String newIngredient(@Valid @ModelAttribute("recipeObj") Recipe recipeObj, Model model,
			Principal principal,@RequestParam("image")MultipartFile image) {
		System.out.println(image.toString());
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));

		return "newrecipe.jsp";
	}

	@PostMapping("/recipes/{recipeId}/ingredients")
	public String createIngredient(@Valid @ModelAttribute("recipeObj") Recipe recipeObj, Model model,
			BindingResult result, Principal principal) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);

		if (result.hasErrors()) {
			return "newrecipe.jsp";
		}
//        User user = this.userService.findByUsername(username);

		userService.createNewRecipe(recipeObj, currentUser);
		System.out.println("You created a new recipe!!!");
		return "redirect:/";
	}

}