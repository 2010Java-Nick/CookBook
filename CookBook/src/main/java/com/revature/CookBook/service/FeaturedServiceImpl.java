package com.revature.CookBook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.CookBook.daos.FeaturedDao;
import com.revature.CookBook.pojos.Featured;
import com.revature.CookBook.pojos.Recipe;

public class FeaturedServiceImpl implements FeaturedService {

	private FeaturedDao featuredDao;

	@Autowired
	public void setFeaturedDao(FeaturedDao featuredDao) {
		this.featuredDao = featuredDao;
	}

	@Override
	public boolean createFeatured(Recipe recipe) {
		Featured featured = new Featured(0, recipe);
		try {
			featuredDao.createFeatured(featured);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<Recipe> readPendingRecipes() {

		List<Recipe> recipes = null;
		try {
			recipes = featuredDao.readPendingRecipes();

		} catch (Exception e) {}
		
		return recipes;
	}

}
