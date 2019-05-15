package com.pwk.springboot.study.multi_threading;

import java.util.concurrent.TimeUnit;

public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(),"SleepRunner");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(),"busyRunner");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(2);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleepThreat:"+(sleepThread.isInterrupted()?"interrupted":"Not interrupted"));
        System.out.println("busyThread:"+(busyThread.isInterrupted()?"Interrupted":"Not interrupted"));
    }

    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){}
        }
    }
}
