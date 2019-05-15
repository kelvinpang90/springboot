package com.pwk.springboot.study.multi_threading;

public class Synchronized {
    public static void main(String[] args){
        synchronized (Synchronized.class){
            m();
        }
    }

    public static synchronized void  m(){}
}
