package com.revature.CookBook.daos;

import java.util.List;

import org.hibernate.HibernateException;

import com.revature.CookBook.pojos.Recipe;

public interface RecipeDao {
	
	public Recipe readRecipe(int recipeId) throws HibernateException;
	
	public void createRecipe(Recipe recipe) throws HibernateException;
	
	public List<Recipe> readAllRecipes() throws HibernateException;
	
	//public Recipe updateRecipe(int recipeId, Recipe recipe);
	
	public void updateRecipe(Recipe recipe) throws HibernateException ;
	
	public void deleteRecipe(int recipeId) throws HibernateException;

}
