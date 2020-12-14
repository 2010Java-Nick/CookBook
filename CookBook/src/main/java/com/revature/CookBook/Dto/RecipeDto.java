package com.revature.CookBook.Dto;


import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.pojos.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto implements Dto<Recipe>{
	
	private String name;
	
	private String author;
	
	private String featured;
	
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
		this.name= recipe.getName();
		this.featured = Boolean.toString(recipe.isFeatured());
		this.servings= recipe.getServings();
		this.prepTime=recipe.getPrepTime();
		this.cookTime=recipe.getCookTime();
		this.steps= recipe.getSteps();
		this.tags=recipe.getTags();
		this.ingredients=recipe.getIngredients();
		this.description=recipe.getDescription();
		this.recipeImage=recipe.getRecipeImage();
		this.author= recipe.getUser().getUsername();
		
		
	}

	@Override
	public Recipe toPojo() {
		Recipe recipe = new Recipe();
		recipe.setName(this.getName());
		recipe.setFeatured(Boolean.parseBoolean(this.getFeatured()));
		recipe.setServings(this.getServings());
		recipe.setPrepTime(this.getPrepTime());
		recipe.setCookTime(this.getCookTime());
		recipe.setSteps(this.getSteps());
		recipe.setTags(this.getTags());
		recipe.setIngredients(this.getIngredients());
		recipe.setDescription(this.getDescription());
		
		User user= new User();
		user.setUsername(this.author);
		recipe.setUser(user);
	
		return recipe;
	}
}