package com.pwk.springboot.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {
    public static void main(String[] args){
        ExecutorService fixPool = Executors.newFixedThreadPool(3);
        fixPool.execute(new printChar(100,'a'));
        fixPool.execute(new printChar(100,'b'));
        fixPool.execute(new printNum(100,7));
        fixPool.shutdown();
        while (!fixPool.isTerminated()){};
        System.out.println();
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        cachedPool.execute(new printChar(100,'a'));
        cachedPool.execute(new printChar(100,'b'));
        cachedPool.execute(new printNum(100,7));
        cachedPool.shutdown();
    }
}

class printChar implements Runnable{
    int count ;
    char c;

    public printChar(int count, char c) {
        this.count = count;
        this.c = c;
    }

    @Override
    public void run() {
        for(int i = 0;i<count;i++){
            System.out.print(c+" ");
        }
    }
}

class printNum implements Runnable{
    int count;
    int num;

    public printNum(int count, int num) {
        this.count = count;
        this.num = num;
    }

    @Override
    public void run() {
        for(int i = 0;i<count;i++){
            System.out.print(num+" ");
        }
    }
}
