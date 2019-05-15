package com.pwk.springboot.study.thread;

public class Producer_Consumer {
}

class Drop{
    private String message;
    private boolean empty = true;

    public synchronized String take() throws InterruptedException {
        while(empty){
            wait();
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void put(String message) throws InterruptedException {
        while(!empty){
            wait();
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Producer implements Runnable{
    private Drop drop;
    public Producer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String[] strings = {"I","am","a","man","and","I","have","two","kids"};
        try {
            for(String string:strings){
                drop.put(string);
                Thread.sleep(500);
            }
            drop.put("DONE");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    private Drop drop;
    public Consumer(Drop drop) {
        this.drop = drop;
    }
    @Override
    public void run() {
        try {
            for(String message = drop.take();!message.equals("DONE");message = drop.take()){
                System.out.print(message+" ");
            }
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}