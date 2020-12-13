package com.revature.CookBook.daos;

import java.util.List;

import com.revature.CookBook.pojos.Recipe;

public interface RecipeDao {
	
	public Recipe readRecipe(int recipeId);
	
	public Recipe createRecipe(Recipe recipe);
	
	public List<Recipe> readAllRecipes();
	
	//public Recipe updateRecipe(int recipeId, Recipe recipe);
	
	public void updateRecipe(Recipe recipe);
	
	public void deleteRecipe(int recipeId);

}
