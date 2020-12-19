package com.revature.CookBook.daos;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
import com.revature.CookBook.pojos.Featured;
import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.pojos.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
public class FeaturedDaoHibernateTest {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private FeaturedDao moderatorDao;
	private Recipe recipe;
	private User user;
	private Featured featured;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		this.user = new User(1, "username", "password", "first", "last", new Authorization(1, "STANDARD"));
		this.recipe = new Recipe(1, "recipe name database", user, true, 3, 20, 20, "Steps 1 ,2 3 ,4 ", "tag1,tag2",
				"ingredient1 ,Ingredient2", "description", null);
		this.featured = new Featured(recipe.getRecipeId(), recipe);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createFeaturedTest() {
		Session session;
		try {
			try {
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(this.user);
				session.save(this.recipe);
				tx.commit();
				session.close();
			} catch (Exception e) {
				fail("Exception thrown in test setup. " + e);
			}

			try {
				moderatorDao.createFeatured(featured);
			} catch (Exception e) {
				fail("Exception thrown when calling 'createFeatured' method. " + e);
			}
		} finally {
			try {
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(this.featured);
				session.delete(this.recipe);
				session.delete(this.user);
				tx.commit();
				session.close();
			} catch (Exception e) {
				fail("Exception thrown in test teardown. " + e);
			}

		}

	}

	@Test
	public void readPendingRecipesTest() {
		Session session;
		try {
			try {
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(this.user);
				session.save(this.recipe);
				session.save(this.featured);
				tx.commit();
				session.close();
			} catch (Exception e) {
				fail("Exception thrown in test setup. " + e);
			}

			try {
				List<Recipe> returnedRecipes = moderatorDao.readPendingRecipes();
				assertTrue("Pending recipes returned empty.", returnedRecipes.size() > 0);
			} catch (Exception e) {
				fail("Exception thrown when calling 'readPendingRecipes' method. " + e);
			}
		} finally {
			try {
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(this.featured);
				session.delete(this.recipe);
				session.delete(this.user);
				tx.commit();
				session.close();
			} catch (Exception e) {
				fail("Exception thrown in test teardown. " + e);
			}

		}

	}

}
