package com.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recipe.models.ReviewrecipeReviewer;

@Repository
public interface ReviewrecipeReviewerRepository extends CrudRepository<ReviewrecipeReviewer, Long> {

}
