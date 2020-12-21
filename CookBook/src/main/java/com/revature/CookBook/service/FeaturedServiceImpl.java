package com.revature.CookBook.service;

import java.util.List;

import com.revature.CookBook.daos.FeaturedDao;
import com.revature.CookBook.dto.RecipeDto;
import com.revature.CookBook.pojos.Featured;
import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.pojos.User;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeaturedServiceImpl implements FeaturedService {

	private FeaturedDao featuredDao;
	private RecipeService recipeService;
	private UserService userService;

	@Autowired
	public void setRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

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

		} catch (HibernateException e) {
			return false;
		}

	}

	@Override
	public List<Recipe> readPendingRecipes() {

		List<Recipe> recipes = null;
		try {
			recipes = featuredDao.readPendingRecipes();

		} catch (HibernateException e) {
		}

		return recipes;
	}

	@Override
	public boolean approvalForFeatured(RecipeDto recipeDto) {

		User user = userService.readUser(recipeDto.getAuthor());
		Recipe recipe = recipeDto.toPojo();
		recipe.setUser(user);

		boolean success = false;

		try {
			if (recipeService.updateRecipe(recipe)) {

				featuredDao.deletePending(recipe);
				success = true;
			}
		} catch (HibernateException e) {
			success = false;
		}

		return success;
	}
}
