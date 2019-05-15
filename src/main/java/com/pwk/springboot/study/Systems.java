package com.pwk.springboot.study;

public class Systems {
    public static void main(String[] args){
//        System.out.println(System.getProperty("java.home"));
//        System.out.println(System.getProperty("java.class.path"));
//        System.out.println(System.getProperty("java.version"));
//        System.out.println(System.getProperty("os.name"));
//        System.out.println(System.getProperty("user.name"));
//        System.out.println(System.getProperty("user.home"));
        Object[] objects = System.getProperties().entrySet().toArray();
        for(int i = 0;i<objects.length;i++){
            System.out.println(objects[i]);

        }
    }
}
