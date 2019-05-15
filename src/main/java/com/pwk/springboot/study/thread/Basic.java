package com.pwk.springboot.study.thread;

public class Basic {
    //同步方法
    public synchronized void synchronized_method(int i){
        System.out.println("abc"+i);
    }

    //同步语句
    public void synchronized_sentence(){
        synchronized (this){
            System.out.println("abc");
        }
    }

    //保护块
    private boolean b = false;

    public synchronized void guardedJoy() throws InterruptedException {
        while(!b){
            System.out.println("waiting...");
            wait();
            System.out.println("waiting completed...");
        }
        System.out.println("guardedJoy");
    }

    public synchronized void notifyJoy() {
        System.out.println("notifyJoy");
        b = true;
        notifyAll();
    }
}

class HelloRunnable implements Runnable{
    private HelloThread helloThread;

    public HelloRunnable(HelloThread helloThread) {
        this.helloThread = helloThread;
    }

    @Override
    public void run() {
        try {
            System.out.println("HelloRunnable");
            helloThread.join();
//                Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from a HelloRunnable");
    }
}

class HelloThread extends Thread{

    @Override
    public void run() {
        System.out.println("HelloThread");
//                Thread.sleep(900);
        if(Thread.interrupted())
            return;
        System.out.println("Hello from a HelloThread");
    }
}