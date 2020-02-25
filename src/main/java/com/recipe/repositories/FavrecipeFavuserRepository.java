package com.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recipe.models.FavrecipeFavuser;

@Repository
public interface FavrecipeFavuserRepository extends CrudRepository<FavrecipeFavuser, Long> {

}