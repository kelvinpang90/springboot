package com.pwk.springboot.redis;

public interface RStringUtil {
    void set(String key, String value);
    void set(String key, String value, Integer seconds);
    String get(String key);
    void del(String key);
    void expire(String key, Integer seconds);
    Long incr(String key);
    String getset(String key, String value);
    long setnx(String key, String value);
}
