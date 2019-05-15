package com.pwk.springboot.study;


/**
 * Polymorphism is an ability of an object to take on many forms
 * the most common use of polymorphism when the parent class reference is used for refer to a child class object
 */
public class Polymorphism {
    public interface Vegearian{};
    public abstract class Animal{
        private String name;
        private int age;
    };
    public class Panda extends Animal implements Vegearian{};

    Animal a = new Panda();
    Vegearian v = new Panda();
    Object o = new Panda();
}
