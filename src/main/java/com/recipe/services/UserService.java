package com.recipe.services;


import java.util.List;
import java.util.Optional;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.recipe.models.Ingredient;
import com.recipe.models.Recipe;
import com.recipe.models.User;
import com.recipe.repositories.CategoryRepository;
import com.recipe.repositories.IngredientRepository;
import com.recipe.repositories.RecipeRepository;
import com.recipe.repositories.ReviewRepository;
import com.recipe.repositories.RoleRepository;
import com.recipe.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private RecipeRepository recipeRepository;
    private ReviewRepository reviewRepository;
    private CategoryRepository categoryRepository;
    private IngredientRepository ingredientRepository;
    private final RestTemplate restTemplate;
    

    

    
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder, RecipeRepository recipeRepository,
			ReviewRepository reviewRepository, CategoryRepository categoryRepository,
			IngredientRepository ingredientRepository, 
			RestTemplateBuilder restTemplateBuilder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.recipeRepository = recipeRepository;
		this.reviewRepository = reviewRepository;
		this.categoryRepository = categoryRepository;
		this.ingredientRepository = ingredientRepository;
	    this.restTemplate = restTemplateBuilder.build();
	}

	// 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    
    //******************recipe********************
	public Recipe createNewRecipe(Recipe recipe,User user) {
		
		recipe.setCreator(user);
		this.recipeRepository.save(recipe);
		return null;

	}
	
	public String starWarsApi() {
		String uri = "https://swapi.co/api/";
		return this.restTemplate.getForObject(uri,String.class);
		
		
	}
	
	public List<Recipe> getAllRecipes() {
		return this.recipeRepository.findAll();
	}

	public Recipe getRecipeById(Long recipeId) {
		Optional<Recipe> r = this.recipeRepository.findById(recipeId);
		if(r.isPresent()) {
			return r.get();
		}
		return null;
	}

	public void deleteRecipe(Long recipeId) {
		this.recipeRepository.deleteById(recipeId);
		System.out.println(recipeId);
	}
	
	public Recipe saveRecipe(Recipe r) {
		return this.recipeRepository.save(r);
	}
	
	//**************ingredients***************
	public Ingredient saveIngredient(Ingredient i) {
		return this.ingredientRepository.save(i);
	}
	
}
