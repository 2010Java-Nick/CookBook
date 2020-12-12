package com.revature.CookBook.service;

import java.util.List;

import com.revature.CookBook.pojos.Recipe;

public interface RecipeService {

	public Recipe createRecipe(Recipe recipe);
	
	public List<Recipe> getAllRecipe();
	
	public void updateRecipe(int recipeId, Recipe recipe); //maybe add exception?
	
	public void deleteRecipe(int recipeId);
	
}
