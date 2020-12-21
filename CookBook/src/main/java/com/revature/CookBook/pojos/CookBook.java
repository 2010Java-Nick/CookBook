package com.revature.CookBook.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cookbook")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "cookBookId")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CookBook {
	
	@ManyToMany(cascade = { CascadeType.ALL} , fetch = FetchType.EAGER )
	@JoinTable(
			name = "cookbook_to_recipe",
			joinColumns = { @JoinColumn (name = "cookbook_id") },
			inverseJoinColumns = { @JoinColumn( name = "recipe_id") }
			)
	public List<Recipe> recipes = new ArrayList<>();
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int cookBookId;

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "author")
	private User user;
	
	@Column(name = "featured")
	private boolean featured;
	
	@Column(name = "cover_image")
	private byte[] coverImage;
	

	public CookBook(String name, User user, boolean featured, byte[] coverImage) {
		super();
		this.name = name;
		this.user = user;
		this.featured = featured;
		this.coverImage = coverImage;
	}

	
}
