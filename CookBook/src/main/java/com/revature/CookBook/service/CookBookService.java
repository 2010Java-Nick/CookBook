package com.revature.CookBook.service;

import java.util.List;

import com.revature.CookBook.daos.CookBookDao;
import com.revature.CookBook.pojos.CookBook;


public interface CookBookService {

	
	public CookBook readCookBook( int recipeId) ;

	public boolean createCookBook(CookBook cookBook);
	
	public List<CookBook> getAllCookBooks();
	
	public boolean updateCookBook(CookBook cookBook); //maybe add exception?
	
	public boolean deleteCookBook(int cookBookId);
	
	public void setCookBookDao(CookBookDao cookBookDao);
	
	
}
