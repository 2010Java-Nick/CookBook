package com.revature.CookBook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.CookBook.config.TestConfig;
import com.revature.CookBook.dto.RecipeDto;
import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.service.RecipeService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@WebAppConfiguration
public class RecipeControllerTest {

	@Mock
	private RecipeService recipeService;
	private RecipeController recipeController;
	private MockMvc mockMvc;

	private Recipe recipe;
	private RecipeDto recipeDto;
	private String recipeJson;

	private User user;
	private UserDto userDto;

	@Mock
	private UserService userService;

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

		this.userDto = new UserDto("username", "password", "Firstname", "Lastname", "STANDARD");
		this.user = userDto.toPojo();

		this.recipeDto = new RecipeDto(1, "Recipe Name", "username", false, 3, 20, 20, "1 step, 2 step",
				"tag1,tag2, tag4 tag4 ", "ingresiend 1 , ingredient 2, ingredient 3 ", "Descriptiooin asja", null);
		this.recipe = recipeDto.toPojo();
		this.recipeJson = obj.writeValueAsString(recipeDto);
	}

	@After
	public void tearDown() throws Exception {
	}

	// @Test
	// public void createRecipeTest() {
	//
	// when( this.userService.createUser(this.user)).thenReturn(true);
	// when( this.recipeService.createRecipe(this.recipe)).thenReturn(true);
	// try {
	// this.mockMvc
	// .perform(MockMvcRequestBuilders.post("/recipe").content(recipeJson)
	// .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
	// .andExpect(status().isCreated());
	// } catch (Exception e) {
	// fail("Method createRecipe threw an exception: " + e);
	// }
	// }
	//
	// @Test
	// public void readRecipeTest() {
	// when(this.recipeService.readRecipe(this.recipe.getRecipeId())).thenReturn(this.recipe);
	// try {
	// this.mockMvc
	// .perform(MockMvcRequestBuilders.get("/recipe/{recipeId}",
	// this.recipe.getRecipeId())
	// .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
	// .andExpect(MockMvcResultMatchers.content().string(recipeJson));
	// } catch (Exception e) {
	// fail("Method readRecipe threw an exception: " + e);
	// }
	//
	// }

	// @Test
	// public void updateRecipeTest() {
	// when(this.recipeService.createRecipe(this.recipe)).thenReturn(true);
	// try {
	// this.mockMvc
	// .perform(MockMvcRequestBuilders.put("/recipe/{recipeId}",
	// this.recipe.getRecipeId()).content(recipeJson)
	// .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
	// .andExpect(status().isOk());
	// } catch (Exception e) {
	// fail("Method createRecipe threw an exception: " + e);
	// }
	// }

}
