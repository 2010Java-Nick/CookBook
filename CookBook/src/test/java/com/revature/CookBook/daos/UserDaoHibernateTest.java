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
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.CookBook.pojos.Authorization;
import com.revature.CookBook.pojos.User;
import com.revature.CookBook.util.SessionFactoryUtil;

public class UserDaoHibernateTest {
	
	private UserDaoHibernate userDao;
	
	private SessionFactory sessionFactory;
	
	private User user;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.userDao = new UserDaoHibernate();
		this.sessionFactory = SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory();
		this.userDao.setSessionFactory(sessionFactory);
		this.user = new User(0, "username", "password", "first", "last", new Authorization(1, "STANDARD"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readUserTest() {
		
		Session session;
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
