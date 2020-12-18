package com.revature.CookBook.daos;

import com.revature.CookBook.pojos.User;

import org.hibernate.HibernateException;

public interface UserDao {

	public User readUser(String username) throws HibernateException;
	
	public void createUser(User user) throws HibernateException;
	
	public void updateUser(User user) throws HibernateException;
	
	public void deleteUser(int id) throws HibernateException;
	
}
