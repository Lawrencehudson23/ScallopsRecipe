package com.recipe.controllers;

import java.security.Principal;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 5f7c5b490794f180dfa8e0ba20f74b4725b46843
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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
<<<<<<< HEAD
import com.recipe.models.Ingredient;
=======
>>>>>>> 5f7c5b490794f180dfa8e0ba20f74b4725b46843
import com.recipe.models.Recipe;
import com.recipe.models.User;
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

        //change add admin role
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
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        System.out.println(userService.starWarsApi());
    	
    	if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }
    @GetMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model,HttpSession session) throws UnirestException  {
        // 1
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        Long userId = currentUser.getId();
        List<Recipe> allRecipes = this.userService.getAllRecipes();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("allRecipes", allRecipes);
        
        
        session.setAttribute("userId", userId);
        HttpResponse<String> response = Unirest.get("https://recipe-puppy.p.rapidapi.com/?p=1")
        		.header("x-rapidapi-host", "recipe-puppy.p.rapidapi.com")
        		.header("x-rapidapi-key", "3a01be6e25msh75a6c8a146c41d5p18acf7jsn5846c5ec8a46")
        		.asString();
        System.out.println("response: "+response.getBody());
        System.out.println("response: "+response.toString());
//        JsonObject jsonObject = new JsonParser().parse(response.getBody()).getAsJsonObject();
        Gson gson = new Gson();
        JsonObject jsonObject =gson.fromJson(response.getBody(), JsonObject.class);
        System.out.println(jsonObject.get("results").getAsJsonArray().get(0).getAsJsonObject().get("thumbnail").getAsString());
        JsonArray array = jsonObject.get("results").getAsJsonArray();
        
        
        
        
        String thumbnail = jsonObject.get("results").getAsJsonArray().get(1).getAsJsonObject().get("thumbnail").getAsString();
        String title = jsonObject.get("results").getAsJsonArray().get(0).getAsJsonObject().get("title").getAsString();
        String href = jsonObject.get("results").getAsJsonArray().get(0).getAsJsonObject().get("href").getAsString();
        String ingredients = jsonObject.get("results").getAsJsonArray().get(0).getAsJsonObject().get("ingredients").getAsString();
        System.out.println("array:"+array);
         for(JsonElement a : array) {
        	 System.out.println("a.title:" + a.getAsJsonObject().get("title").getAsString());
         }
//        gson.toJson(response.getBody());
        model.addAttribute("array", array);
        model.addAttribute("thumbnail", thumbnail);
        model.addAttribute("title", title);
        model.addAttribute("href", href);
        model.addAttribute("ingredients", ingredients);

        return "index.jsp";
    }


    @GetMapping("/recipe/new")
    public String newRecipe(@Valid @ModelAttribute("recipeObj") Recipe recipeObj,Model model,Principal principal) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        
        
    	return "newrecipe.jsp";
    }
    @PostMapping("/recipe/new")
    public String createRecipe( @Valid @ModelAttribute("recipeObj") Recipe recipeObj,Model model,BindingResult result, Principal principal) {
    	String username = principal.getName();
    	User currentUser = userService.findByUsername(username);
    	model.addAttribute("currentUser", currentUser);
<<<<<<< HEAD
=======
    	
>>>>>>> 5f7c5b490794f180dfa8e0ba20f74b4725b46843
        if (result.hasErrors()) {
            return "newrecipe.jsp";
        }
//        User user = this.userService.findByUsername(username);
        
<<<<<<< HEAD
        
        Recipe newRecipe = userService.createNewRecipe(recipeObj,currentUser);
        System.out.println("You created a new recipe!!!");
     
=======
        userService.createNewRecipe(recipeObj,currentUser);
        System.out.println("You created a new recipe!!!");
>>>>>>> 5f7c5b490794f180dfa8e0ba20f74b4725b46843
        return "redirect:/";
    }
    @GetMapping("recipes/{recipeId}")
    public String displayRecipe(@PathVariable("recipeId")Long recipeId,Model model) {
    	Recipe r = this.userService.getRecipeById(recipeId);
    	model.addAttribute("r", r);
<<<<<<< HEAD
    	
    	String[] ingredients = r.getIngredients().split(",");
    	
    	for (String i : ingredients) {
    		i.substring(0, i.length()-1);
    	}
    	
    	model.addAttribute("ingredients","ingredients");    	
    	
=======
>>>>>>> 5f7c5b490794f180dfa8e0ba20f74b4725b46843
    	return "displayRecipe.jsp";
    }
    @GetMapping("recipes/{recipeId}/edit")
    public String displayEditRecipe(@PathVariable("recipeId")Long recipeId,Model model,@Valid @ModelAttribute("recipeObj") Recipe recipeObj) {
    	Recipe r = this.userService.getRecipeById(recipeId);
    	model.addAttribute("r", r);
    	return "editRecipe.jsp";
    }
    @PutMapping("recipes/{recipeId}/edit")
    public String editRecipe(@PathVariable("recipeId")Long recipeId,Model model,@Valid @ModelAttribute("recipeObj") Recipe recipeObj, BindingResult result,Principal principal) {
    	String username = principal.getName();
    	User currentUser = userService.findByUsername(username);
    	model.addAttribute("currentUser", currentUser);
    	if(result.hasErrors()) {
    		return "editRecipe.jsp";
    	}
        userService.createNewRecipe(recipeObj,currentUser);
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
    public String newIngredient(@Valid @ModelAttribute("recipeObj") Recipe recipeObj,Model model,Principal principal) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        
        
    	return "newrecipe.jsp";
    }
    @PostMapping("/recipes/{recipeId}/ingredients")
    public String createIngredient( @Valid @ModelAttribute("recipeObj") Recipe recipeObj,Model model,BindingResult result, Principal principal) {
    	String username = principal.getName();
    	User currentUser = userService.findByUsername(username);
    	model.addAttribute("currentUser", currentUser);
    	
        if (result.hasErrors()) {
            return "newrecipe.jsp";
        }
//        User user = this.userService.findByUsername(username);
        
        userService.createNewRecipe(recipeObj,currentUser);
        System.out.println("You created a new recipe!!!");
        return "redirect:/";
    }
    
}