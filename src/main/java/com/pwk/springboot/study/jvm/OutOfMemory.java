package com.pwk.springboot.study.jvm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutOfMemory {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("");
        heap();
    }

    //heap OutOfMemory
    private static void heap(){
        List<String> list = new ArrayList<>();
        while(true){
            list.add("");
        }
    }

    private static int i = 0;
    //stack stackOverFlow
    private static void stackSOF(){
        try {
            i++;
            stackSOF();
        }catch (StackOverflowError e){
            System.out.println(i);
        }
    }

    //stack outOfMemory
    private static void stackOOM(){
        while (true){
            new Thread(() -> dontStop()).start();
        }
    }

    private static void dontStop(){
        while (true){}
    }
}
