package com.revature.CookBook.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.CookBook.daos.RecipeDao;
import com.revature.CookBook.pojos.Recipe;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	RecipeDao recipeDao;
	
	@Autowired
    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

	@Override
	public Recipe readRecipe(int recipeId) {
		
		Recipe recipe= null;
		try {
			recipe = recipeDao.readRecipe(recipeId);
		}
		catch ( HibernateException e) {}
		 
		 return recipe;
		
	}

	@Override
	public boolean createRecipe(Recipe recipe) {
		try {
			recipeDao.createRecipe(recipe);
			return true;
		}
		catch ( HibernateException e) {}
		return false;
	}

	@Override
	public List<Recipe> getAllRecipes() {
		
		List<Recipe> recipeList= new ArrayList<Recipe>();
		try {
			recipeList = recipeDao.readAllRecipes();
		}
		catch ( HibernateException e) {}
		 
		 return recipeList;
	}

	@Override
	public boolean updateRecipe(Recipe recipe) {
		try {
		 recipeDao.updateRecipe(recipe);
		 return true;
		}
		catch ( HibernateException e) {}
		return false;
	}

	@Override
	public boolean deleteRecipe(int recipeId) {
		try {
			recipeDao.deleteRecipe(recipeId);
			return true;
		}
		catch ( HibernateException e) {}
		return false;
	}



}
