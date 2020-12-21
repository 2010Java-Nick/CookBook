package com.revature.CookBook.daos;

// import static org.junit.Assert.*;

// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
// import org.junit.Test;
import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.revature.CookBook.config.AppConfig;
// import com.revature.CookBook.pojos.Authorization;
// import com.revature.CookBook.pojos.CookBook;
// import com.revature.CookBook.pojos.User;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
public class CookBookDaoHibernateTest {

	// @Autowired
	// private SessionFactory sessionFactory;
	
	// @Autowired
	// private CookBookDao cookBookDao;
	
	// @Autowired
	// private UserDao userDao;
	
	// private CookBook cookBook;
	// private User user;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// this.user= new User(4, "username", "password", "first", "last", new Authorization(1, "STANDARD"));
	    // this.cookBook = new CookBook ("new cook book", user, false, null);
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void readCookBook() {
//		
//		Session session;
//		User user= new User(4, "username", "password", "first", "last", new Authorization(1, "STANDARD"));
//		
//		try{
//			
//			try{
//				session = sessionFactory.openSession();
//				Transaction tx = session.beginTransaction();
//				session.save(this.user);
//				session.save(this.cookBook);
//				tx.commit();
//				session.close();
//			}
//			catch (Exception e) {
//				fail("Exception thrown in test setup. " + e);
//			}
//			
//			try{
//				CookBook returnedCookBook= cookBookDao.readCookBook(this.cookBook.getCookBookId());
//				assertEquals("Returned cookBook doesn't match given cookBook.", this.cookBook, returnedCookBook);
//			}
//			catch (Exception e) {
//				fail("Exception thrown when calling 'readCookBook' method. " + e);
//			}
//		}finally {
//			try{
//				session = sessionFactory.openSession();
//				Transaction tx = session.beginTransaction();
//				
//				session.delete(this.cookBook);
//				session.delete(this.user);
//				tx.commit();
//				session.close();
//			}
//			catch (Exception e) {
//				fail("Exception thrown in test teardown. " + e); 
//			}
//
//	}
//	}
}
