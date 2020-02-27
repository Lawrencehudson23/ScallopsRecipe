package com.recipe.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// NEW
	@Size(min = 3)
	private String username;
	// NEW
	@Size(min = 5)
	private String password;
	@Transient
	private String passwordConfirmation;
	@Column(updatable = false)

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Recipe> createdrecipes;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "favrecipes_favusers",joinColumns = @JoinColumn(name = "favuser_id"),inverseJoinColumns = @JoinColumn(name = "favrecipe_id"))
	private List<Recipe> favrecipes;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "reviews", joinColumns = @JoinColumn(name = "reviewer_id"), inverseJoinColumns = @JoinColumn(name = "reviewrecipe_id"))
	private List<Recipe> reviewrecipes;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Recipe> getCreatedrecipes() {
		return createdrecipes;
	}

	public void setCreatedrecipes(List<Recipe> createdrecipes) {
		this.createdrecipes = createdrecipes;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Recipe> getFavrecipes() {
		return favrecipes;
	}

	public void setFavrecipes(List<Recipe> favrecipes) {
		this.favrecipes = favrecipes;
	}

	public List<Recipe> getReviewrecipes() {
		return reviewrecipes;
	}

	public void setReviewrecipes(List<Recipe> reviewrecipes) {
		this.reviewrecipes = reviewrecipes;
	}


}