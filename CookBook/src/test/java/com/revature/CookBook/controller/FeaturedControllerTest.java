package com.revature.CookBook.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.CookBook.config.TestConfig;
import com.revature.CookBook.dto.RecipeDto;
import com.revature.CookBook.dto.UserDto;
import com.revature.CookBook.pojos.Authorization;
import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.pojos.User;
import com.revature.CookBook.service.FeaturedService;
import com.revature.CookBook.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@WebAppConfiguration
public class FeaturedControllerTest {

	@Mock
	private FeaturedService featuredService;
	private FeaturedController featuredController;
	private MockMvc mockMvc;

	private Recipe recipe;
	private List<Recipe> recipes;
	private User user;
	private RecipeDto recipeDto;
	private List<RecipeDto> recipeDtoList;
	private String recipeJson;
	private String featuredListJson;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		featuredController = new FeaturedController();
		featuredService = Mockito.mock(FeaturedService.class);
		featuredController.setFeaturedService(featuredService);
		mockMvc = MockMvcBuilders.standaloneSetup(featuredController).build();

		ObjectMapper obj = new ObjectMapper();

		this.user = new User(1, "username", "password", "first", "last", new Authorization(1, "STANDARD"));
		this.recipe = new Recipe(1, "recipe name database", user, true, 3, 20, 20, "Steps 1 ,2 3 ,4 ", "tag1,tag2",
				"ingredient1 ,Ingredient2", "description", null);
		
		this.recipes = new ArrayList<>();
		this.recipes.add(recipe);
		
		this.recipeDto = new RecipeDto(recipe);
		this.recipeDtoList = new ArrayList<>();
		this.recipeDtoList.add(recipeDto);
		
		this.recipeJson = obj.writeValueAsString(recipeDto);
		this.featuredListJson = obj.writeValueAsString(recipeDtoList);
		
		this.recipe = recipeDto.toPojo();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createFeaturedTest() {
		
		when(this.featuredService.createFeatured(this.recipe)).thenReturn(true);
		try {
			this.mockMvc
					.perform(MockMvcRequestBuilders.post("/featured").content(recipeJson)
					.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isCreated());
		} catch (Exception e) {
			fail("Method createFeatured threw an exception: " + e);
		}
	}
	
	@Test
	public void readPendingRecipesTest() {
		
		when(this.featuredService.readPendingRecipes()).thenReturn(this.recipes);
		try {
			this.mockMvc
					.perform(MockMvcRequestBuilders.get("/featured")).andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.content().string(featuredListJson));
		} catch (Exception e) {
			fail("Method readPendingRecipes threw an exception: " + e);
		}
	}

}
