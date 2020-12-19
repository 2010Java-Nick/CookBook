package com.revature.CookBook.daos;

import java.util.List;

import org.hibernate.HibernateException;

import com.revature.CookBook.pojos.Featured;
import com.revature.CookBook.pojos.Recipe;

public interface FeaturedDao {

	public void createFeatured(Featured featured) throws HibernateException;
	
	public List<Recipe> readPendingRecipes() throws HibernateException;
	
}
