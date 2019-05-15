package com.pwk.springboot.study.multi_threading.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sample_Condition_Queue<T> {
    private T[] items;
    private int addIndex,removeIndex,count;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    @SuppressWarnings("unchecked")
    public Sample_Condition_Queue(int size) {
        items = (T[]) new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[addIndex] = t;
            if(++addIndex==items.length)
                addIndex = 0;
            count++;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            T item = items[removeIndex];
            if(++removeIndex==items.length)
                removeIndex = 0;
            count--;
            notFull.signal();
            return item;
        }finally {
            lock.unlock();
        }
    }
}
