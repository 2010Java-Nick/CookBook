package com.revature.CookBook.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weekly_cookbook")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "weeklyId")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyCookBook {
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			
			@Column(name = "id")
			private int weeklyId;
			
			@Column(name = "cookbook_id")
			private int cookBookId;
			
			@Column(name = "curation_date")
			private int curationDate;
	
			@Column(name = "recipe_1")
			private Recipe recipe1;
			
			@Column(name = "recipe_2")
			private Recipe recipe2;
			
			@Column(name = "recipe_3")
			private Recipe recipe3;
			
			@Column(name = "recipe_4")
			private Recipe recipe4;
			
			@Column(name = "recipe_5")
			private Recipe recipe5;
			
			@Column(name = "recipe_6")
			private Recipe recipe6;
			
			@Column(name = "recipe_7")
			private Recipe recipe7;

			public WeeklyCookBook(int cookBookId, int curationDate, Recipe recipe1, Recipe recipe2, Recipe recipe3, Recipe recipe4,
					Recipe recipe5, Recipe recipe6, Recipe recipe7) {
				super();
				this.cookBookId = cookBookId;
				this.curationDate = curationDate;
				this.recipe1 = recipe1;
				this.recipe2 = recipe2;
				this.recipe3 = recipe3;
				this.recipe4 = recipe4;
				this.recipe5 = recipe5;
				this.recipe6 = recipe6;
				this.recipe7 = recipe7;
			}
			
			

}
