package com.pwk.springboot.redis.impl;

import com.pwk.springboot.redis.RStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Transactional
@Repository("rStringUtil")
public class RStringUtilImpl implements RStringUtil {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void set(String key, String value, Integer seconds) {
        redisTemplate.opsForValue().set(key,value,seconds, TimeUnit.SECONDS);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void expire(String key, Integer seconds) {
        redisTemplate.expire(key,seconds,TimeUnit.SECONDS);
    }

    @Override
    public Long incr(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    @Override
    public String getset(String key, String value) {
        return Objects.requireNonNull(redisTemplate.opsForSet().add(key, value)).toString();
    }

    @Override
    public long setnx(String key, String value) {
        return 0;
    }
}
