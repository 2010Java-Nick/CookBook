package com.revature.CookBook.service;

import java.util.List;

import com.revature.CookBook.pojos.Featured;
import com.revature.CookBook.pojos.Recipe;

public interface FeaturedService {

	public boolean createFeatured(Recipe recipe);

	public List<Recipe> readPendingRecipes();

}
