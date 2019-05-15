package com.pwk.springboot.study.multi_threading.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairTest {

    private static ReentrantLock2 fairLock = new ReentrantLock2(true);
    private static ReentrantLock2 unfairLock = new ReentrantLock2(false);

    public static void main(String[] args){
        fair();
    }

    private static void fair(){
        testLock(fairLock);
    }

    private static void unfair(){
        testLock(unfairLock);
    }

    private static void testLock(ReentrantLock2 lock){
        //启动5个job
        for(int i = 0;i<5;i++){
            Thread thread = new Thread(new Job(lock),"thread "+i);
            thread.start();
        }
    }

    private static class Job implements Runnable{
        private ReentrantLock2 lock;

        public Job(ReentrantLock2 lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            //打印当前Thread和等待队列中的Thread
            System.out.println(Thread.currentThread());
            System.out.println(lock.getQueuedThreads());
        }
    }

    static class ReentrantLock2 extends ReentrantLock{
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        protected Collection<Thread> getQueuedThreads() {
            List<Thread> threads = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(threads);
            return threads;
        }
    }
}
