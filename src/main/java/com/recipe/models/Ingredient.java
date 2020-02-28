package com.recipe.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String items;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="recipe_id")
//    private Recipe recipe;

    public Ingredient() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

    
  

}
