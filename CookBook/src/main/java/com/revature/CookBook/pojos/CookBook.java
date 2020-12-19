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

@Entity
@Table(name = "cookbook")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "cookBookId")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CookBook {
	

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
