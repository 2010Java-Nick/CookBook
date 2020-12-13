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

import com.revature.CookBook.daos.UserDao;
import com.revature.CookBook.pojos.Authorization;
import com.revature.CookBook.pojos.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private static UserDao mockDao;

    @InjectMocks
	private static UserServiceImpl userService;	

	private User user;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
        userService.setUserDao(mockDao);
		this.user = new User(0, "username", "password", "first", "last", new Authorization(1, "STANDARD"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readUserTest() {
        try {
            userService.readUser(user.getUserId());

            verify(mockDao).readUser(user.getUserId());
        } 
        catch (Exception e){
            fail("Exception thrown in readUser test: " + e);
        }
	}
	
	@Test
	public void createUserTest() {
        try {
            userService.createUser(user);

            verify(mockDao).createUser(user);
        } 
        catch (Exception e){
            fail("Exception thrown in readUser test: " + e);
        }
	}
	
	@Test
	public void updateUserTest() {
        try {
            userService.updateUser(user);

            verify(mockDao).updateUser(user);
        } 
        catch (Exception e){
            fail("Exception thrown in readUser test: " + e);
        }
	}
	
	@Test
	public void deleteUserTest() {
        try {
            userService.deleteUser(user.getUserId());

            verify(mockDao).deleteUser(user.getUserId());
        } 
        catch (Exception e){
            fail("Exception thrown in readUser test: " + e);
        }
	}

}
