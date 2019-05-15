package com.pwk.springboot.study;

class Parent{}

class Child extends Parent{}

public class Instanceof_Operator {
    public static void main(String[] args){
        //use of instanceof, if class child is extend from class parent,then class child is instance of class parent
        Child child = new Child();
        Parent parent = new Parent();
        Parent parent1 = new Child();
        if(child instanceof Parent){
            System.out.println("child is instance of parent");
        }
        if(child instanceof Object){
            System.out.println("child is instance of Object");
        }
        if(parent instanceof Child){
            System.out.println("parent is instance of child");
        }
        if(parent1 instanceof Child){
            System.out.println("parent1 is instance of child");
        }
        Object obj = parent1;

        System.out.println(obj instanceof Parent);
        System.out.println(obj instanceof Child);
    }
}
