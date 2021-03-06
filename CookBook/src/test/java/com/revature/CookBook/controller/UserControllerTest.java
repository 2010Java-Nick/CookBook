package com.revature.CookBook.controller;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.CookBook.config.TestConfig;
import com.revature.CookBook.dto.UserDto;
import com.revature.CookBook.pojos.User;
import com.revature.CookBook.service.UserService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@WebAppConfiguration
public class UserControllerTest {

	@Mock
	private UserService userService;
	private UserController userController;
	private MockMvc mockMvc;

	private User user;
	private UserDto userDto;
	private String userJson;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		userController = new UserController();
		userService = Mockito.mock(UserService.class);
		userController.setUserService(userService);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

		ObjectMapper obj = new ObjectMapper();

		this.userDto = new UserDto("Nick_R00lz", "password", "Nick", "Jurassic", "STANDARD");
		this.user = userDto.toPojo();
		this.userJson = obj.writeValueAsString(userDto);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createUserTest() {

		when(this.userService.createUser(this.user)).thenReturn(true);
		try {
			this.mockMvc
					.perform(MockMvcRequestBuilders.post("/user").content(userJson)
					.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isCreated());
		} catch (Exception e) {
			fail("Method createUser threw an exception: " + e);
		}

	}

	@Test
	public void readUserTest() {

		when(this.userService.readUser(this.user.getUsername())).thenReturn(this.user);
		try {
			this.mockMvc
					.perform(MockMvcRequestBuilders.get("/user/{username}", this.user.getUsername())
					.accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.content().string(userJson));
		} catch (Exception e) {
			fail("Method readUser threw an exception: " + e);
		}
	}

}
