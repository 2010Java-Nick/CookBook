package com.revature.CookBook.controller;

import static org.junit.Assert.fail;
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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.CookBook.controller.RecipeControllerTest.TestConfig;
import com.revature.CookBook.daos.RecipeDao;
import com.revature.CookBook.dto.RecipeDto;
import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.service.RecipeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RecipeControllerTest.TestConfig.class })
@WebAppConfiguration
public class RecipeControllerTest {
	
	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages = { "com.revature.CookBook" })
	public static class TestConfig {
		@Bean
		public SessionFactory sessionFactory() {
	
			return Mockito.mock(SessionFactory.class);
		}
	
	
		@Bean
		public RecipeDao recipeDao() {
	
			return Mockito.mock(RecipeDao.class);
		}
	
		@Bean
		public RecipeService recipeService() {
	
			return Mockito.mock(RecipeService.class);
		}
	}
	@Mock
	private MockMvc mockMvc;
	private RecipeController recipeController;
	private RecipeService recipeService;
	
	private Recipe recipe;
	private RecipeDto recipeDto;
	private String recipeJson;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setUp() throws Exception {

		recipeController = new RecipeController();
		recipeService = Mockito.mock(RecipeService.class);
		recipeController.setRecipeService(recipeService);
		mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

		ObjectMapper obj = new ObjectMapper();
		this.recipeDto = new RecipeDto(1, "Recipe Name"," Author Name ",false, 3, 20, 20,"1 step, 2 step", "tag1,tag2, tag4 tag4 ", "ingresiend 1 , ingredient 2, ingredient 3 ", "Descriptiooin asja", null );
		this.recipe = recipeDto.toPojo();
		this.recipeJson = obj.writeValueAsString(recipeDto);
	}
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void createRecipeTest() {
		when(this.recipeService.createRecipe(this.recipe)).thenReturn(true);
		try {
			this.mockMvc
					.perform(MockMvcRequestBuilders.post("/recipe").content(recipeJson)
					.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());
		} catch (Exception e) {
			fail("Method createRecipe threw an exception: " + e);
		}

	}
	
	@Test
	public void readRecipeTest() {
		when(this.recipeService.readRecipe(this.recipe.getRecipeId())).thenReturn(this.recipe);
		try {
			this.mockMvc
					.perform(MockMvcRequestBuilders.get("/recipe/{recipeId}", this.recipe.getRecipeId())
					.accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.content().string(recipeJson));
		} catch (Exception e) {
			fail("Method readRecipe threw an exception: " + e);
		}
		
	}
	
	@Test
	public void updateRecipeTest() {
		when(this.recipeService.createRecipe(this.recipe)).thenReturn(true);
		try {
			this.mockMvc
					.perform(MockMvcRequestBuilders.put("/recipe/{recipeId}", this.recipe.getRecipeId()).content(recipeJson)
					.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());
		} catch (Exception e) {
			fail("Method createRecipe threw an exception: " + e);
		}
	}

}
