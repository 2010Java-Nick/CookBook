package com.revature.CookBook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.CookBook.dto.RecipeDto;
import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.service.FeaturedService;

@RestController
public class FeaturedController {

	FeaturedService featuredService;

	@Autowired
	public void setFeaturedService(FeaturedService featuredService) {
		this.featuredService = featuredService;
	}

	@PostMapping("/featured")
	public boolean createFeatured(@RequestBody RecipeDto recipe, HttpServletResponse response) {

		if (featuredService.createFeatured(recipe.toPojo())) {
			response.setStatus(201);
			return true;
		} else {
			response.setStatus(400);
			return false;
		}

	}

	@GetMapping("/featured")
	public List<RecipeDto> readPendingRecipes(HttpServletResponse response) {

		List<Recipe> recipes = featuredService.readPendingRecipes();
		List<RecipeDto> recipeDtos = new ArrayList<>(recipes.size());

		recipes.forEach(recipe -> {
			recipeDtos.add(new RecipeDto(recipe));
		});
		
		return recipeDtos;
	}

	@PutMapping("/featured")
	public boolean approvalForFeatured(@RequestBody RecipeDto recipe, HttpServletResponse response){

		if (featuredService.approvalForFeatured(recipe)) {
			response.setStatus(201);
			return true;
		} else {
			response.setStatus(400);
			return false;
		}
	}

}
