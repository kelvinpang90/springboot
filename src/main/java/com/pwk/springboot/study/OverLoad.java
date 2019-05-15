package com.pwk.springboot.study;

public class OverLoad {
    static abstract class Human{
        void say(){
            System.out.println("Human");
        }
    }
    static class Man extends Human{
        @Override
        void say() {
            System.out.println("Man");
        }
    }
    static class Women extends Human{
        @Override
        void say() {
            System.out.println("Women");
        }
    }
    static void sayHello(Human human){
        System.out.println("human");
    }
    static void sayHello(Man man){
        System.out.println("man");
    }
    static void sayHello(Women women){
        System.out.println("women");
    }
    public static void main(String args[]){
        Human man = new Man();
        Human women = new Women();
        sayHello(man);
        sayHello(women);
        man.say();
        women.say();
    }
}
