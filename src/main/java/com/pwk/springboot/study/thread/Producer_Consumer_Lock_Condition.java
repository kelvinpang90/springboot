package com.pwk.springboot.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//用加锁同步来实现生产者/消费者模式
public class Producer_Consumer_Lock_Condition<T> {
    private T[] items;
    private int size ;
    private final Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private int head,tail,count;

    public Producer_Consumer_Lock_Condition(int maxSize) {
        this.size = maxSize;
        items = (T[])new Object[size];
    }

    public void put(T t){
        lock.lock();
        try {
            while(items.length == size) {
                notFull.await();
            }
            items[tail] = t;
            if(++tail == items.length)
                tail = 0;
            count++;
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        T item = null;
        try {
            while (items.length == 0)
                notEmpty.await();

            item = items[head];
            items[head] = null;

            if(++head == items.length)
                head = 0;


            count--;
            notEmpty.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return item;
    }
}
