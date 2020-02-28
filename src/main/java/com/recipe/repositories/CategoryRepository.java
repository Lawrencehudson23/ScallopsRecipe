package com.recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recipe.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByName(String name);
}

