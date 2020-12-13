package com.revature.CookBook.daos;

import java.sql.SQLException;

import com.revature.CookBook.pojos.User;

public interface UserDao {

	public User readUser(int id) throws SQLException;
	
	public void createUser(User user) throws SQLException;
	
	public void updateUser(User user) throws SQLException;
	
	public void deleteUser(int id) throws SQLException;
	
}
