package com.revature.CookBook.daos;

import java.util.List;

import org.hibernate.HibernateException;

import com.revature.CookBook.pojos.CookBook;
//import com.revature.CookBook.pojos.WeeklyCookBook;


public interface CookBookDao {
	
public CookBook readCookBook(int cookBookId) throws HibernateException;
	
	public void createCookBook(CookBook cookBook) throws HibernateException;
	
	public List<CookBook> readAllCookBooks() throws HibernateException;
	
	
	public void updateCookBook(CookBook cookBook) throws HibernateException ;
	
	public void deleteCookBook(int cookBookId) throws HibernateException;
	
	//...WeeklyCookBook.................................................................//
	
//   public WeeklyCookBook readWeeklyCookBook(int weeklyCookBookId) throws HibernateException;
//	
//	public void createWeekly weeklyCookBook(WeeklyCookBook weeklyCookBook) throws HibernateException;
//	
//	public List<WeeklyCookBook> readAllWeeklyCookBooks() throws HibernateException;
//	
//	public void updateWeeklyCookBook(WeeklyCookBook weeklyCookBook) throws HibernateException ;
//	
//	public void deleteWeeklyCookBook(int weeklyCookBookId) throws HibernateException;
	
	
	


}
