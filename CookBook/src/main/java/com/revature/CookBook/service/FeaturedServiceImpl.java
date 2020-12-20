package com.revature.CookBook.service;

import java.util.List;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
>>>>>>> 694d4a2c3012ae4b72a7e66f2e96e5f519ae92f0

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.CookBook.daos.FeaturedDao;
import com.revature.CookBook.pojos.Featured;
import com.revature.CookBook.pojos.Recipe;

@Service
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
