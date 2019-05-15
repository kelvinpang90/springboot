package com.pwk.springboot.study.multi_threading;

public class Join {
    public static void main(String[] args){
        Thread previousThread = Thread.currentThread();
        for(int i = 0;i<10;i++){
            Thread thread = new Thread(new JoinThread(previousThread),"Thread "+i);
            thread.start();
            previousThread = thread;
        }
        System.out.println(Thread.currentThread().getName()+" ended");
    }

    static class JoinThread implements Runnable{
        Thread previousThread;

        public JoinThread(Thread previousThread) {
            this.previousThread = previousThread;
        }

        @Override
        public void run() {
            try {
                previousThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" ended");
        }
    }
}
