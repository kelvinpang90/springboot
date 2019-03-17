package com.pwk.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    public void addUser(String key,String value){
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expireAt(key, Date.from(LocalDateTime.of(2019,3,3,11,35).toInstant(ZoneOffset.ofHours(8))));
    }
}
