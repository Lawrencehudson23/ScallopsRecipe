package com.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recipe.models.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
}

