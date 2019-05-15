package com.pwk.springboot.study.multi_threading;

import java.util.concurrent.TimeUnit;

public class Daemon {

    public static void main(String[] args){
        Thread thread = new Thread(new DaemonThread());
        thread.setDaemon(true);
        thread.start();
        thread.run();
    }

    static class DaemonThread implements Runnable{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
