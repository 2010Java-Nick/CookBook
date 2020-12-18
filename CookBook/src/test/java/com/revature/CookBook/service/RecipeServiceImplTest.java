package com.revature.CookBook.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.CookBook.daos.RecipeDao;
import com.revature.CookBook.pojos.Authorization;
import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.pojos.User;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceImplTest {

	@Mock
    private static RecipeDao mockDao;
	
	@InjectMocks
		private static RecipeServiceImpl recipeService;
		
		private Recipe recipe;
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}
		@Before
		public void setUp() throws Exception {
			
			recipeService.setRecipeDao(mockDao);
			
			User user= new User(1, "username", "password", "first", "last", new Authorization(1, "STANDARD"));
			this.recipe= new Recipe ("name",user,true, 3, 20, 20, "Steps 1 ,2 3 ,4 ", "tag1,tag2", "ingredient1 ,Ingredient2","description",null);
			
		}
		@After
		public void tearDown() throws Exception {
		}
		
		
		@Test
		public void readRecipeTest() {
	        try {
	            recipeService.readRecipe(recipe.getRecipeId());

	            verify(mockDao).readRecipe(recipe.getRecipeId());
	        } 
	        catch (Exception e){
	            fail("Exception thrown in readRecipe test: " + e);
	        }
		}
		
		@Test
		public void createRecipeTest() {
	        try {
	            recipeService.createRecipe(recipe);

	            verify(mockDao).createRecipe(recipe);
	        } 
	        catch (Exception e){
	            fail("Exception thrown in readRecipe test: " + e);
	        }
		}
		
		@Test
		public void updateRecipeTest() {
	        try {
	            recipeService.updateRecipe(recipe);

	            verify(mockDao).updateRecipe(recipe);
	        } 
	        catch (Exception e){
	            fail("Exception thrown in readRecipe test: " + e);
	        }
		}
		
		@Test
		public void deleteRecipeTest() {
	        try {
	            recipeService.deleteRecipe(recipe.getRecipeId());

	            verify(mockDao).deleteRecipe(recipe.getRecipeId());
	        } 
	        catch (Exception e){
	            fail("Exception thrown in readRecipe test: " + e);
	        }
		}
}
