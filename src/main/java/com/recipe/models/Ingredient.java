package com.recipe.models;


<<<<<<< HEAD
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
=======
>>>>>>> 5f7c5b490794f180dfa8e0ba20f74b4725b46843
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
<<<<<<< HEAD
import javax.persistence.OneToOne;
=======
import javax.persistence.ManyToOne;
>>>>>>> 5f7c5b490794f180dfa8e0ba20f74b4725b46843


@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
    
    private String items;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="recipe_id")
//    private Recipe recipe;
=======
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="recipe_id")

    private Recipe recipe;
>>>>>>> 5f7c5b490794f180dfa8e0ba20f74b4725b46843

    public Ingredient() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

<<<<<<< HEAD
	

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

=======
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
>>>>>>> 5f7c5b490794f180dfa8e0ba20f74b4725b46843
    
  

}
