package com.revature.CookBook.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

//import HotelReservationSpring.pojos.Room; import user object


	@Entity
	@Table(name = "Recipe")
	@JsonIdentityInfo(
			generator = ObjectIdGenerators.PropertyGenerator.class,
			//recipe ID
			property = "id")

	@Data
	public class Recipe {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		@Column(name = "id")
		private int recipeId;
		
		@Column(name = "name")
		private String name;
		
		@ManyToOne
		@JoinColumn(name = "author")
		private User user;
		
		@Column(name = "featured")
		private boolean featured;
		
		@Column(name = "servings")
		private int servings;
		
		@Column(name = "prep_time")
		private String prepTime;
		
		@Column(name = "cook_time")
		private String cookTime;

		@Column(name = "steps")
		private String steps;
		
		@Column(name = "tags")
		private String tags;
		
		@Column(name = "ingredients")
		private String ingredients;
		
		@Column(name = "description")
		private String description;

		public Recipe(int recipeId, String name, User user, boolean featured, int servings, String prepTime,
				String cookTime, String steps, String tags, String ingredients, String description) {
			super();
			this.recipeId = recipeId;
			this.name = name;
			this.user = user;
			this.featured = featured;
			this.servings = servings;
			this.prepTime = prepTime;
			this.cookTime = cookTime;
			this.steps = steps;
			this.tags = tags;
			this.ingredients = ingredients;
			this.description = description;
		}

		public Recipe() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	}



