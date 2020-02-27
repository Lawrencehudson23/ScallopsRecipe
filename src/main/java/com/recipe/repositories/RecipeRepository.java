package com.recipe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recipe.models.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>{
	List<Recipe> findAll();
	Optional<Recipe> findByName(String name);
}
