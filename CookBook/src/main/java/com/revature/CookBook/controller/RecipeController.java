package com.revature.CookBook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.revature.CookBook.dto.RecipeDto;
import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.pojos.User;
import com.revature.CookBook.service.RecipeService;
import com.revature.CookBook.service.UserService;

@RestController
public class RecipeController {

	RecipeService recipeService;
	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	// @RequestMapping(path = "recipe", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("recipe")
	public void createRecipe(@RequestBody RecipeDto recipeDto) {
		System.out.println(recipeDto.toString());
		Recipe recipe = recipeDto.toPojo();
		User user = userService.readUser(recipeDto.getAuthor());
		recipe.setUser(user);
		boolean result = recipeService.createRecipe(recipe);
		ResponseEntity<RecipeDto> re = new ResponseEntity<RecipeDto>(HttpStatus.CREATED);

	}

	@RequestMapping(path = "recipe/{recipeId}", method = RequestMethod.GET)
	public RecipeDto readRecipe(@PathVariable(name = "recipeId") int recipeId) {
		Recipe recipe = recipeService.readRecipe(recipeId);

		ResponseEntity<RecipeDto> re = new ResponseEntity<RecipeDto>(HttpStatus.OK);

		RecipeDto recipeDto = new RecipeDto(recipe);
		return recipeDto;
	}
	@RequestMapping(path = "recipe", method = RequestMethod.GET)
	public List<RecipeDto> readRecipes() {
		List <RecipeDto> recipeDtoList=new ArrayList<>();
		List <Recipe> recipeList = recipeService.getAllRecipes();
		for ( Recipe recipe: recipeList ) {
			recipeDtoList.add( new RecipeDto(recipe));
		}
		return recipeDtoList;
	}
	@RequestMapping(path = "/recipe/{recipeId}", method = RequestMethod.PUT)
	public void updateRecipe(@PathVariable(name = "recipeId") RecipeDto recipe) {

		recipeService.updateRecipe(recipe.toPojo());
		ResponseEntity<RecipeDto> re = new ResponseEntity<RecipeDto>(HttpStatus.OK);

	}
	
	
	
	

}
