package com.revature.CookBook.dto;

import com.revature.CookBook.pojos.CookBook;
import com.revature.CookBook.pojos.Recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CookBookDto implements Dto<CookBook>{
	
	private String name;
	
	private String author;
	
	private boolean featured;
	
	private byte[] coverImage;
	
	
	
	public CookBookDto(CookBook cookBook) {
		super();
		this.name= cookBook.getName();
		this.author= cookBook.getUser().getUsername();
		this.featured = cookBook.isFeatured();
		this.coverImage=cookBook.getCoverImage();
		
	}
	
	
	

	@Override
	public CookBook toPojo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
