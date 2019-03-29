package com.pwk.springboot.service;

import com.pwk.springboot.dao.UserMapper;
import com.pwk.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserService {
    @Resource
    private UserMapper userMapper;
    public User selectByPrimaryKey(int id){
        return userMapper.selectByPrimaryKey(id);
    }
    public void addUser(User user){
        userMapper.insert(user);
    }
}
