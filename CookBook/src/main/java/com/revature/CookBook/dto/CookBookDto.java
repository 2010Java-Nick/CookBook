package com.revature.CookBook.dto;

import java.util.ArrayList;
import java.util.List;

import com.revature.CookBook.pojos.CookBook;
import com.revature.CookBook.pojos.Recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CookBookDto implements Dto<CookBook>{
	
	private int id;
	
	private String name;
	
	private String author;
	
	private boolean featured;
	
	private byte[] coverImage;
	
	private List<RecipeDto> recipeDtos;
		

	public CookBookDto(CookBook cookBook) {
		super();
		this.name = cookBook.getName();
		this.id = cookBook.getCookBookId();
		this.author = cookBook.getUser().getUsername();
		this.featured = cookBook.isFeatured();
		this.coverImage = cookBook.getCoverImage();
		List<Recipe> newRecipes = new ArrayList<>();
		newRecipes = cookBook.getRecipes(); 
		List <RecipeDto> recipeDtoList=new ArrayList<>();
		List <Recipe> recipeList=newRecipes;
		for ( Recipe recipe: recipeList ) {
			recipeDtoList.add( new RecipeDto(recipe));
		}
	
		this.recipeDtos =recipeDtoList;
		
	}
	
	
	

	@Override
	public CookBook toPojo() {
		CookBook cookBook = new CookBook();
		cookBook.setCookBookId(this.getId());
		cookBook.setName(this.getName());
		cookBook.setFeatured(this.isFeatured());
		cookBook.setCoverImage(this.getCoverImage());
		
		return cookBook;
	}
	
	
	
	

}
