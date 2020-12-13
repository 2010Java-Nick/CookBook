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
import com.revature.CookBook.pojos.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)

public class UserDaoHibernateTest {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserDao userDao;	

	private User user;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.user = new User(0, "username", "password", "first", "last", new Authorization(1, "STANDARD"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readUserTest() {
		Session session;
		try {
			try{
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(this.user);
				tx.commit();
				System.out.println(user);
				session.close();
			}
			catch (Exception e) {
				fail("Exception thrown in test setup. " + e);
			}
			
			try{
				User returnedUser = userDao.readUser(this.user.getUserId());
				assertEquals("Returned user doesn't match given user.", this.user, returnedUser);
			}
			catch (Exception e) {
				fail("Exception thrown when calling 'readUser' method. " + e);
			}

		} finally {
			try{
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(this.user);
				tx.commit();
				session.close();
			}
			catch (Exception e) {
				fail("Exception thrown in test teardown. " + e); 
			}
		}
	}
	
	@Test
	public void createUserTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void updateUserTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void deleteUserTest() {
		fail("Not yet implemented");
	}

}
