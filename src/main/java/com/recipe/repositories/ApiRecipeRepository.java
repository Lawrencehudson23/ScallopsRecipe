package com.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recipe.models.ApiRecipe;
@Repository
public interface ApiRecipeRepository extends CrudRepository<ApiRecipe, Long>{

}
