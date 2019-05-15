package com.pwk.springboot.study.thread;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        thread.start();
//        thread1.start();

        Person p1 = new Person("Peter",Person.SEX.MALE,"abc@hotmail.com", LocalDate.of(1995,10,10));
        Person p2 = new Person("Kate", Person.SEX.FEMALE,"def@hotmail.com",LocalDate.of(1998,1,22));

//        new Thread(() -> p1.bow(p2)).start();
//        new Thread(()->p2.bow(p1)).start();

//        Basic b = new Basic();
//        new Thread(() -> {
//            try {
//                b.guardedJoy();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(b::notifyJoy).start();

        Drop drop = new Drop();
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();

//        ForkJoinPool pool = new ForkJoinPool();
//        Fork_Join task = new Fork_Join(1,10);
//        Future<Integer> result = pool.submit(task);
//        System.out.println(result.get());

    }
}
