package com.revature.CookBook.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.CookBook.dao.RecipeDaoHibernate;
import com.revature.CookBook.pojos.Recipe;

public class RecipeDaoHibernateTest {
	
	@Autowired
	private RecipeDaoHibernate recipeDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Recipe recipe;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
