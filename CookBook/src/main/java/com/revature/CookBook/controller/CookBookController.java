package com.revature.CookBook.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.CookBook.dto.CookBookDto;
import com.revature.CookBook.pojos.CookBook;
import com.revature.CookBook.service.CookBookService;

@RestController
public class CookBookController {

	CookBookService cookBookService;
	
	@Autowired
	public void setCookBookService(CookBookService cookBookService) {
		this.cookBookService = cookBookService;
	}
	
	//will need to call suer service to make a user for author
	//Create recipe
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PostMapping("recipe")
//	public void createRecipe(@RequestBody RecipeDto recipeDto) {
//		System.out.println(recipeDto.toString());
//		Recipe recipe = recipeDto.toPojo();
//		User user = userService.readUser(recipeDto.getAuthor());
//		recipe.setUser(user);
//		boolean result = recipeService.createRecipe(recipe);
//		ResponseEntity<RecipeDto> re = new ResponseEntity<RecipeDto>(HttpStatus.CREATED);
//
//	}

	@RequestMapping(path = "cookbook/{cookbookId}", method = RequestMethod.GET)
	public CookBookDto readCookBook(@PathVariable(name = "cookbookId") int cookBookId) {

		CookBook cookBook = cookBookService.readCookBook(cookBookId);
		ResponseEntity<CookBookDto> re = new ResponseEntity<CookBookDto>(HttpStatus.OK);
		CookBookDto cookBookDto = new CookBookDto(cookBook);
		return cookBookDto;
	}
	
}
