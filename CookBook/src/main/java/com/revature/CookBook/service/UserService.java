package com.revature.CookBook.service;

import com.revature.CookBook.daos.UserDao;
import com.revature.CookBook.pojos.User;

public interface UserService {
    
    public User readUser(String username);

    public boolean createUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(int userId);

    public void setUserDao(UserDao userDao);

}
