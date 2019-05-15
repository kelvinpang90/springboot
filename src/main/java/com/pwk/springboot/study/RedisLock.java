package com.pwk.springboot.study;

import com.pwk.springboot.redis.RStringUtil;
import com.pwk.springboot.redis.impl.RStringUtilImpl;

public class RedisLock {
    private RStringUtil redis = new RStringUtilImpl();

    public boolean getLock(String key,int expire){
        //根据过期时间获取future time;
        long newExpire = System.currentTimeMillis()+expire*1000;
        //根据添加锁的KV值，判断锁是否获取成功
        long status = redis.setnx(key,String.valueOf(newExpire));
        //若获取锁成功，则设置锁过期时间
        if(status == 1){
            redis.expire(key,expire);
            return true;
        }else{
            //若新建锁的KV失败，则获取锁KV值的过期时间(value),若已经过期，则再次尝试获取锁，否则返回获取失败；
            String oldExpire = redis.get(key);
            if (System.currentTimeMillis()-Long.valueOf(oldExpire)>0){
                newExpire = System.currentTimeMillis()+expire*1000;
                Long value = Long.valueOf(redis.getset(key,String.valueOf(newExpire)));
                return value == newExpire;
            }
            return false;
        }
    }
}
