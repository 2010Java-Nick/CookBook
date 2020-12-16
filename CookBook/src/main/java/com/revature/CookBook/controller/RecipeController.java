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

//	@RequestMapping(path = "/view-a-recipe", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipe) {
//
//		Recipe newRecipe = recipeService.readRecipe(recipe.toPojo());
//		
//		ResponseEntity<RecipeDto> re = new ResponseEntity<RecipeDto>(new RecipeDto(newGuest), HttpStatus.CREATED);
//		
//		return re;

//	}
	
	@RequestMapping(path = "recipe/{recipeId}", method = RequestMethod.GET , produces = "text/plain")
	public String readRecipe(@PathVariable(name = "recipeId")int recipeId) {
		return "hello";
	}


}
