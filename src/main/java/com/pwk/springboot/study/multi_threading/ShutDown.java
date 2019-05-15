package com.pwk.springboot.study.multi_threading;

import java.util.concurrent.TimeUnit;

public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        //method one to terminate a thread
        Thread countThread = new Thread(new Runner(),"Runner 1");
        countThread.start();
        TimeUnit.SECONDS.sleep(2);
        countThread.interrupt();

        //method two to terminate a thread
        Runner runner = new Runner();
        countThread = new Thread(runner,"Runner 2");
        countThread.start();
        TimeUnit.SECONDS.sleep(2);
        runner.cancel();
    }

    static class Runner implements Runnable{

        private long count;
        private volatile boolean on = true;

        @Override
        public void run() {
            while(on&&!Thread.currentThread().isInterrupted())
                count++;
            System.out.println("count="+count);
        }

        public void cancel(){
            on = false;
        }
    }
}
