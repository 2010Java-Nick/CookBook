package com.revature.CookBook.daos;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.revature.CookBook.config.AppConfig;
import com.revature.CookBook.pojos.Authorization;
import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.pojos.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
public class RecipeDaoHibernateTest {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private RecipeDao recipeDao;
	
	private Recipe recipe;
	//private User user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	
		User user= new User(1, "username", "password", "first", "last", new Authorization(1, "STANDARD"));
		this.recipe= new Recipe ("name",user,true, 3, 20, 20, "Steps 1 ,2 3 ,4 ", "tag1,tag2", "ingredient1 ,Ingredient2","description",null);
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readRecipeTest() {
		Session session;
	
		try{
			try{
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				
				session.save(this.recipe);
				tx.commit();
				session.close();
			}
			catch (Exception e) {
				fail("Exception thrown in test setup. " + e);
			}
			
			try{
				Recipe returnedRecipe = recipeDao.readRecipe(this.recipe.getRecipeId());
				assertEquals("Returned recipe doesn't match given recipe.", this.recipe, returnedRecipe);
			}
			catch (Exception e) {
				fail("Exception thrown when calling 'readRecipe' method. " + e);
			}
		}finally {
			try{
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(this.recipe);
				tx.commit();
				session.close();
			}
			catch (Exception e) {
				fail("Exception thrown in test teardown. " + e); 
			}
			
		}
		
	}
	
	@Test
	public void createRecipeTest() {
		Session session;
		try {			
			try{
				recipeDao.createRecipe(this.recipe);
			}
			catch (Exception e) {
				fail("Exception thrown when calling 'createRecipe' method. " + e);
			}
		} finally {
			try{
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(this.recipe);
				tx.commit();
				session.close();
			}
			catch (Exception e) {
				fail("Exception thrown in test teardown. " + e); 
			}
		}
	}
	
	@Test
	public void updateRecipeTest() {
		Session session;
		try {
			try{
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(this.recipe);
				tx.commit();
				session.close();
			}
			catch (Exception e) {
				fail("Exception thrown in test setup. " + e);
			}
			
			try{
				recipe.setName("different name");
				recipe.setFeatured(false);
				recipe.setServings(10);
				recipe.setPrepTime(prepTime);
				recipeDao.updateRecipe(this.recipe);
			}
			catch (Exception e) {
				fail("Exception thrown when calling 'updateUser' method. " + e);
			}

		} finally {
			try{
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(this.recipe);
				tx.commit();
				session.close();
			}
			catch (Exception e) {
				fail("Exception thrown in test teardown. " + e); 
			}
		}
	}
	
	@Test
	public void deleteUserTest() {
		Session session;
		try {
			try{
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(this.user);
				tx.commit();
				session.close();
			}
			catch (Exception e) {
				fail("Exception thrown in test setup. " + e);
			}
			
			try{
				userDao.deleteUser(this.user.getUserId());
			}
			catch (Exception e) {
				fail("Exception thrown when calling 'deleteUser' method. " + e);
			}

		} finally {
			try{
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(this.user);
				tx.commit();
				session.close();
				fail("Object was not properly deleted from Dao call"); 
			}
			catch (Exception e) {}
		}
	}
	

}
