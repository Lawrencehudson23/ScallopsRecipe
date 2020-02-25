package com.recipe.services;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.recipe.models.Recipe;
import com.recipe.models.User;
import com.recipe.repositories.CategoryRepository;
import com.recipe.repositories.FavrecipeFavuserRepository;
import com.recipe.repositories.IngredientRepository;
import com.recipe.repositories.RecipeRepository;
import com.recipe.repositories.ReviewrecipeReviewerRepository;
import com.recipe.repositories.RoleRepository;
import com.recipe.repositories.UnitOfMeasureRepository;
import com.recipe.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private RecipeRepository recipeRepository;
    private FavrecipeFavuserRepository favrecipeFavuserRepository;
    private ReviewrecipeReviewerRepository reviewrecipeReviewerRepository;
    private CategoryRepository categoryRepository;
    private IngredientRepository ingredientRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private final RestTemplate restTemplate;
    

    

    
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder, RecipeRepository recipeRepository,
			FavrecipeFavuserRepository favrecipeFavuserRepository,
			ReviewrecipeReviewerRepository reviewrecipeReviewerRepository, CategoryRepository categoryRepository,
			IngredientRepository ingredientRepository, UnitOfMeasureRepository unitOfMeasureRepository,
			RestTemplateBuilder restTemplateBuilder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.recipeRepository = recipeRepository;
		this.favrecipeFavuserRepository = favrecipeFavuserRepository;
		this.reviewrecipeReviewerRepository = reviewrecipeReviewerRepository;
		this.categoryRepository = categoryRepository;
		this.ingredientRepository = ingredientRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
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


	public Recipe createNewRecipe(Recipe recipe,User user) {
		
		recipe.setCreator(user);
		this.recipeRepository.save(recipe);
		return null;

	}
	
	public String starWarsApi() {
		String uri = "https://swapi.co/api/";
		return this.restTemplate.getForObject(uri,String.class);
	}
}
