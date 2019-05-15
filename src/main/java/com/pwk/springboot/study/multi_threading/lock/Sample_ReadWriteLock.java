package com.pwk.springboot.study.multi_threading.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Sample_ReadWriteLock {
    private Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = reentrantReadWriteLock.readLock();
    private Lock writeLock = reentrantReadWriteLock.writeLock();

    public void put(String key,Object value){
        writeLock.lock();
        try {
            map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }

    public Object get(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }
}
