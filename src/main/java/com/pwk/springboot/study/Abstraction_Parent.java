package com.pwk.springboot.study;


/**
 * abstraction is a process of hiding the implementation details from the users,only the functionality is provided to the user.
 * in other words,the user will have the information on what the objects does instead of how it does
 * abstract class
 * 1.abstract class may or may not contain abstract method
 * 2.if contain of abstract method, class must be declared abstract
 * 3.if a class declared abstract, it cannot be instantiated
 * 4.to use a abstract class, you have to inherit from it, provide implementation of all abstract methods
 */
public abstract class Abstraction_Parent {
    private String name;
    private int age;

    public abstract void formatName(String name);
    public abstract void formatAge(int age);
}
