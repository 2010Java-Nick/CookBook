package com.revature.CookBook.daos;

import com.revature.CookBook.pojos.User;

public interface UserDao {

	public User readUser(int id);
	
	public void createUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
}
