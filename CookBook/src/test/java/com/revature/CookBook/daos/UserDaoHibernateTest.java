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
		Session session;
		try {			
			try{
				userDao.createUser(this.user);
			}
			catch (Exception e) {
				fail("Exception thrown when calling 'createUser' method. " + e);
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
	public void updateUserTest() {
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
				user.setFirstName("newFirst");
				user.setLastName("newLast");
				user.setAuthorization(new Authorization(2, "AFFILIATED"));

				userDao.updateUser(this.user);
			}
			catch (Exception e) {
				fail("Exception thrown when calling 'updateUser' method. " + e);
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
