package com.revature.CookBook.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.WebApplicationInitializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.CookBook.daos.UserDao;
import com.revature.CookBook.dto.UserDto;
import com.revature.CookBook.pojos.User;
import com.revature.CookBook.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UserControllerTest.TestConfig.class })
@WebAppConfiguration
public class UserControllerTest {

	public static class TestConfig implements WebApplicationInitializer {

		static SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);

		static UserDao userDao = Mockito.mock(UserDao.class);

		static UserService userService = Mockito.mock(UserService.class);

		@Override
		public void onStartup(ServletContext servletContext) throws ServletException {
			// TODO: something, maybe?

		}

		@Bean
		@Scope(value = "singleton")
		public SessionFactory sessionFactory() {

			return sessionFactory;
		}

		@Bean
		public UserDao userDao() {

			return userDao;
		}

		@Bean
		public UserService userService() {

			return userService;
		}

	}

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

		mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();

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

		when(TestConfig.userService.createUser(this.user)).thenReturn(true);
		try {
			this.mockMvc
					.perform(MockMvcRequestBuilders.post("/user").content(userJson)
							.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated());
		} catch (Exception e) {
			fail("Method createUser threw an exception: " + e);
		}

	}

	@Test
	public void readUserTest() {

		when(TestConfig.userService.readUser(this.user.getUserId())).thenReturn(this.user);
		try {
			this.mockMvc
					.perform(MockMvcRequestBuilders.get("/user/{username}", this.user.getUsername())
							.accept(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$").value(userJson));
		} catch (Exception e) {
			fail("Method readUser threw an exception: " + e);
		}
	}

}
