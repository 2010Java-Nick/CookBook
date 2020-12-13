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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import HotelReservationSpring.pojos.Room; import user object


	@Entity
	@Table(name = "Recipe")
	@JsonIdentityInfo(
			generator = ObjectIdGenerators.PropertyGenerator.class,
			//recipe ID
			property = "id")

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class Recipe {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		@Column(name = "id")
		private int recipeId;
		
		@Column(name = "name")
		private String name;
//		
//		@ManyToOne
//		@JoinColumn(name = "author")
//		private User user;
//		
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

		
	}



