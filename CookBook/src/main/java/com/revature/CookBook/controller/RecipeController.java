package com.revature.CookBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.CookBook.dto.Dto;
import com.revature.CookBook.dto.RecipeDto;
import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.service.RecipeService;

@RestController
@RequestMapping("")
public class RecipeController {
	
	RecipeService recipeService;
	
	@Autowired
	public void setRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping(path = "/createRecipe", method = RequestMethod.POST)
	public String createRecipe(@RequestBody RecipeDto recipe) {

		recipeService.createRecipe(recipe.toPojo());
		
		ResponseEntity<RecipeDto> re = new ResponseEntity<RecipeDto>( HttpStatus.CREATED);
		
		return "created";
	}
	
	@RequestMapping(path = "recipe/{recipeId}", method = RequestMethod.GET )
	public Recipe readRecipe(@PathVariable(name = "recipeId")int recipeId) {
		Recipe recipe= recipeService.readRecipe(recipeId);
		
		return recipe;
	}

	@RequestMapping(path = "/updateRecipe", method = RequestMethod.PUT)
	public void updateRecipe(RecipeDto recipe) {
		
		recipeService.updateRecipe(recipe.toPojo());
	}

}
