package com.pwk.springboot.controller;


import com.pwk.springboot.domain.User;
import com.pwk.springboot.redis.RedisService;
import com.pwk.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @GetMapping("/hello")
    public String hello(){
        System.out.println(userService.getAllUsers());
        return "Hello World";
    }

    @GetMapping("/addUser")
    public String addUser(){
        User user = new User();
        user.setUsername("kelvin");
        user.setPassword("123456");
        userService.addUser(user);
        return "addUser success";
    }

    @GetMapping("/addRedis")
    public String addRedis(){
        redisService.addUser("cherry","654321");
        return "addRedis success";
    }
}
