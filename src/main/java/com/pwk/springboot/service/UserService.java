package com.pwk.springboot.service;

import com.pwk.springboot.dao.UserDao;
import com.pwk.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    public void addUser(User user){
        userDao.addUser(user);
    }
}
