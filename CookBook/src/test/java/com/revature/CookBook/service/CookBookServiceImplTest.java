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

import com.revature.CookBook.daos.CookBookDao;
import com.revature.CookBook.pojos.Authorization;
import com.revature.CookBook.pojos.CookBook;
import com.revature.CookBook.pojos.User;


@RunWith(MockitoJUnitRunner.class)
public class CookBookServiceImplTest {
	
	@Mock
    private static CookBookDao mockDao;
	
	@InjectMocks
	private static CookBookServiceImpl cookBookService;
	
	private CookBook cookBook; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		cookBookService.setCookBookDao(mockDao);
		
		User user= new User(1, "username", "password", "first", "last", new Authorization(1, "STANDARD"));
		this.cookBook= new CookBook ("new cook book", user, false, null);
	}


	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readCookBook() {
		
        try {
            cookBookService.readCookBook(cookBook.getCookBookId());

            verify(mockDao).readCookBook(cookBook.getCookBookId());
        } 
        catch (Exception e){
            fail("Exception thrown in readCookBook test: " + e);
        
	}
	}
	
	@Test
	public void createCookBookTest() {
        try {
            cookBookService.createCookBook(cookBook);

            verify(mockDao).createCookBook(cookBook);
        } 
        catch (Exception e){
            fail("Exception thrown in readCookBook test: " + e);
        }
	}

}
