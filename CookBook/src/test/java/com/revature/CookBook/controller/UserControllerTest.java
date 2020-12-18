package com.revature.CookBook.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.CookBook.config.AppConfig;
import com.revature.CookBook.daos.UserDao;
import com.revature.CookBook.dto.UserDto;
import com.revature.CookBook.pojos.User;
import com.revature.CookBook.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UserControllerTest.TestConfig.class })
@WebAppConfiguration
public class UserControllerTest {

	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages = { "com.revature.CookBook" })
	public static class TestConfig {

		@Bean
		public SessionFactory sessionFactory() {

			return Mockito.mock(SessionFactory.class);
		}

		@Bean
		public UserDao userDao() {

			return Mockito.mock(UserDao.class);
		}

		@Bean
		public UserService userService() {

			return Mockito.mock(UserService.class);
		}
	}

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
