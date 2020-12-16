package com.revature.CookBook.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.CookBook.daos.RecipeDao;
import com.revature.CookBook.pojos.Recipe;

public interface RecipeService {
	
	public Recipe readRecipe( int recipeId) ;

	public boolean createRecipe(Recipe recipe);
	
	public List<Recipe> getAllRecipes();
	
	public boolean updateRecipe(Recipe recipe); //maybe add exception?
	
	public boolean deleteRecipe(int recipeId);
	
	public void setRecipeDao(RecipeDao recipeDao);
	
}
