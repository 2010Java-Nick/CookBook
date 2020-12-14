package com.revature.CookBook.Dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.pojos.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto implements Dto<Recipe>{
	
	private String name;
	
	private String user;
	
	private String featured;
	
	private String servings;
	
	private String prepTime;
	
	private String cookTime;

	private String steps;
	
	private String tags;
	
	private String ingredients;
	
	private String description;
	
	//private String recipeImage;
	
	
	public RecipeDto(Recipe recipe) {
		super();
		this.name= recipe.getName();
		this.featured = Boolean.toString(recipe.isFeatured());
		this.servings= Integer.toString(recipe.getServings());
		this.prepTime=Integer.toString(recipe.getPrepTime());
		this.cookTime=Integer.toString(recipe.getCookTime());
		this.steps= recipe.getSteps();
		this.tags=recipe.getTags();
		this.ingredients=recipe.getIngredients();
		this.description=recipe.getDescription();
		//this.recipeImage=recipe.getRecipeImage();
		this.user=Integer.toString(recipe.getUser().getUserId());
	}

	@Override
	public Recipe toPojo() {
		Recipe recipe = new Recipe();
		recipe.setName(this.getName());
		recipe.setFeatured(Boolean.parseBoolean(this.getFeatured()));
		recipe.setServings(Integer.parseInt(this.getServings()));
		recipe.setPrepTime(Integer.parseInt(this.getPrepTime()));
		recipe.setCookTime(Integer.parseInt(this.getCookTime()));
		recipe.setSteps(this.getSteps());
		recipe.setTags(this.getTags());
		recipe.setIngredients(this.getIngredients());
		recipe.setDescription(this.getDescription());
		
		User user= new User();
		//recipe.setUser(this.getUser());
		
		return null;
	}
}
