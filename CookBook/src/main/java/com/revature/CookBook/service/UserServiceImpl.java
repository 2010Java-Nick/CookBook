package com.revature.CookBook.service;

import java.sql.SQLException;

import com.revature.CookBook.daos.UserDao;
import com.revature.CookBook.pojos.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User readUser(int userId) {

        User user = null;

        try {
            user = userDao.readUser(userId);

        } catch (SQLException e){ }

        return user;
    }

    @Override
    public boolean createUser(User user) {

        try {
            userDao.createUser(user);
            return true;

        } catch (SQLException e){
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {

        try {
            userDao.updateUser(user);
            return true;

        } catch (SQLException e){
            return false;
        }
    }

    @Override
    public boolean deleteUser(int userId) {

        try {
            userDao.deleteUser(userId);
            return true;

        } catch (SQLException e){
            return false;
        }
    }
    
}
