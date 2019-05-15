package com.pwk.springboot.study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda_Expression {

    public static void main(String[] args){
        String[] str = {"a","b","c"};

        List<String> list = Arrays.asList(str);

        for(String s:list){
            System.out.print(s+";");
        }
        System.out.println();

        list.forEach((s) -> System.out.print(s+";"));
        System.out.println();

        list.forEach(System.out::print);


        //annoymous inner class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("execute thread");
            }
        }).start();

        //lambda expression
        new Thread(()-> System.out.println("execute run by lambda expression")).start();

        //annoymous inner class
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("execute runnable");
            }
        };

        //lambda expression
        Runnable runnable2 = ()-> System.out.println("execute runnable by lambda expression");

        runnable1.run();
        runnable2.run();

        //sorting collection with lambda
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Arrays.sort(str,((o1, o2) -> o1.compareTo(o2)));
        Arrays.sort(str,(String::compareTo));
    }

}
