package com.revature.CookBook.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.CookBook.daos.FeaturedDao;
import com.revature.CookBook.pojos.Featured;
import com.revature.CookBook.pojos.Recipe;

@RunWith(MockitoJUnitRunner.class)
public class FeaturedServiceImplTest {

	@Mock
	private static FeaturedDao mockDao;

	@InjectMocks
	private static FeaturedServiceImpl featuredService;

	private Featured featured;
	private Recipe recipe;
	private List<Recipe> recipeList;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		this.recipe = new Recipe(1, "recipe name database", null, true, 3, 20, 20, "Steps 1 ,2 3 ,4 ", "tag1,tag2",
				"ingredient1 ,Ingredient2", "description", null);
		this.featured = new Featured(0, recipe);
		recipeList = new ArrayList<Recipe>();
		recipeList.add(recipe);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createFeaturedTest() {
		try {
			featuredService.createFeatured(recipe);

			verify(mockDao).createFeatured(featured);
		} catch (Exception e) {
			fail("Exception thrown in createFeatured test: " + e);
		}
	}

	@Test
	public void readPendingRecipesTest() {
		try {
			when(mockDao.readPendingRecipes()).thenReturn(recipeList);
			
			List<Recipe> returned = featuredService.readPendingRecipes();

			verify(mockDao).readPendingRecipes();
			assertEquals("Returned list does not match expected.", returned, recipeList);
		} catch (Exception e) {
			fail("Exception thrown in createFeatured test: " + e);
		}
	}

}
