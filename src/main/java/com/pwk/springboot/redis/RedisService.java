package com.pwk.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    public void addUser(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }
}
