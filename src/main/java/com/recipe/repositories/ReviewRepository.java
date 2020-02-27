package com.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recipe.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
