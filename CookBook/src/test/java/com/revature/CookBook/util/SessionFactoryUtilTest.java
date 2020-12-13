package com.revature.CookBook.util;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SessionFactoryUtilTest {

	private SessionFactoryUtil sessionFactoryUtil;	
	
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
	public void getSessionFactoryUtilTest() {
		
		try {
			sessionFactoryUtil = SessionFactoryUtil.getSessionFactoryUtil();
			SessionFactory session = sessionFactoryUtil.getSessionFactory();
			if (session == null){
				fail("Session factory was returned as null");
			}
		}
		catch(Exception e) {
			fail("Threw exception. " + e);
		}
	}

}
