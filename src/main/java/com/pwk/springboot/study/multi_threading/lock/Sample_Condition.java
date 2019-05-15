package com.pwk.springboot.study.multi_threading.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sample_Condition {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();



    //same as Object.wait()
    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
        }finally {
            lock.unlock();
        }
    }

    //same as Object.notify()
    public void conditionSignal(){
        lock.lock();
        try {
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
