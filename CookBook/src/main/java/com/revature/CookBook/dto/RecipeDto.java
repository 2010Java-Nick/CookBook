package com.revature.CookBook.dto;


import com.revature.CookBook.pojos.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto implements Dto<Recipe>{
	
	private int id;
	
	private String name;
	
	private String author;
	
	private boolean featured;
	
	private int servings;
	
	private int prepTime;
	
	private int cookTime;

	private String steps;
	
	private String tags;
	
	private String ingredients;
	
	private String description;
	
	private byte[] recipeImage;
	
	
	public RecipeDto(Recipe recipe) {
		super();
		this.id=recipe.getRecipeId();
		this.name= recipe.getName();
		this.author= recipe.getUser().getUsername();
		this.featured = recipe.isFeatured();
		this.servings= recipe.getServings();
		this.prepTime=recipe.getPrepTime();
		this.cookTime=recipe.getCookTime();
		this.steps= recipe.getSteps();
		this.tags=recipe.getTags();
		this.ingredients=recipe.getIngredients();
		this.description=recipe.getDescription();
		this.recipeImage=recipe.getRecipeImage();
		
		
		
	}

	@Override
	public Recipe toPojo() {
		Recipe recipe = new Recipe();
		recipe.setRecipeId(this.getId());
		recipe.setName(this.getName());
		recipe.setFeatured(this.isFeatured());
		recipe.setServings(this.getServings());
		recipe.setPrepTime(this.getPrepTime());
		recipe.setCookTime(this.getCookTime());
		recipe.setSteps(this.getSteps());
		recipe.setTags(this.getTags());
		recipe.setIngredients(this.getIngredients());
		recipe.setDescription(this.getDescription());
		

		//recipe.setUser(user);
	
		return recipe;
	}
}
