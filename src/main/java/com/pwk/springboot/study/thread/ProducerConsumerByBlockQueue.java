package com.pwk.springboot.study.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerByBlockQueue {
    public static void main(String args[]){
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new ProducerTask());
        service.execute(new ConsumerTask());
        service.shutdown();
    }

    private static BlockingQueue<Integer> queue= new ArrayBlockingQueue<>(10);

    static class ProducerTask implements Runnable{

        @Override
        public void run() {
            int i = 0;
            try {
                while (true){
                    System.out.println("put "+i);
                    queue.put(i++);
                    Thread.sleep(100);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ConsumerTask implements Runnable{

        @Override
        public void run() {
            try {
                while (true){
                    int i = queue.take();
                    System.out.println("take "+i);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


