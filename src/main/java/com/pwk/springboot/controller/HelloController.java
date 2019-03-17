package com.pwk.springboot.controller;


import com.pwk.springboot.domain.User;
import com.pwk.springboot.domain.UserElasticSearch;
import com.pwk.springboot.redis.RedisService;
import com.pwk.springboot.repository.UserRepository;
import com.pwk.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable("id") String id){
        System.out.println(userService.selectByPrimaryKey(Integer.valueOf(id)));
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

    @GetMapping("/elasticSearchAdd")
    public String add(){
        UserElasticSearch user = new UserElasticSearch();
        user.setId(System.currentTimeMillis());
        user.setUsername("kelvin");
        user.setPassword("123456");
        userRepository.save(user);
        return "elasticSearch Add Success";
    }

    @GetMapping(value = "elasticSearchGet/{id}")
    public String get(@PathVariable("id") String id){
        userRepository.findById(Long.valueOf(id)).ifPresent(System.out::println);
        System.out.println(userRepository.count());
        Iterable<UserElasticSearch> it = userRepository.findAll();
        for (UserElasticSearch anIt : it) {
            System.out.println(anIt);
        }
        System.out.println("elasticSearchGet");
        return null;
    }
}
