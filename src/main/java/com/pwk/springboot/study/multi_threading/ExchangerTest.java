package com.pwk.springboot.study.multi_threading;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTest {
    private final static Exchanger<String> e = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);



    public static void main(String[] args){
//        ProductService.World();
//        ProductService productService = new ProductServiceImpl();
//        productService.Hello();
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String str = "I am Thread A";
                System.out.println(str);
                try {
                    String str1 = e.exchange(str);
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(str1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String str = "I am Thread B";
                System.out.println(str);
                try {
                    String str1 = e.exchange(str);
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(str1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am thread C");
            }
        });
        threadPool.shutdown();
    }
}
