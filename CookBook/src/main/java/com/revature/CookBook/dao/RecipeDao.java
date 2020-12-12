package com.revature.CookBook.dao;

import java.util.List;

import com.revature.CookBook.pojos.Recipe;

public interface RecipeDao {
	
	public Recipe createRecipe(Recipe recipe);
	
	public List<Recipe> readAllRecipes();
	
	public void updateRecipe(int recipeId, Recipe recipe);
	
	public void deleteRecipe(int recipeId);

}
