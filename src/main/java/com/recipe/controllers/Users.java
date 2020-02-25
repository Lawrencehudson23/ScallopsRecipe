package com.recipe.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
   
        return "redirect:/login";
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
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
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
    	model.addAttribute("currentUser", userService.findByUsername(username));
  	
    	userValidator.validate(recipeObj, result);
        if (result.hasErrors()) {
            return "newrecipe.jsp";
        }
        User user = this.userService.findByUsername(username);
        
        userService.createNewRecipe(recipeObj,user);
               
        return "redirect:/";
    }
}