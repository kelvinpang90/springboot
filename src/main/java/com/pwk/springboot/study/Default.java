package com.pwk.springboot.study;

public class Default {
    public static void main(String[] args){
        Default1 d = new Test();
        d.print();
    }

    interface Default1 {
        default void print() {
            System.out.println("default");
        }
    }

    static class Test implements Default1{
        public void print(){
            Default1.super.print();
            System.out.println("Test");
        }
    }

}



