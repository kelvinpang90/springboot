package com.pwk.springboot.study;

public class Interface {


    public static void main(String[] args) {
        Administrator i = new Manager();
        User u = new Manager();
        i.add(1);
        i.update();

        u.add(0);
        u.update();
    }
}

interface User  {
    int i = 0;

    void add(int i);

    default void update() {
        System.out.println(i);
    }
}

interface Administrator {
    int i = 1;

    void add(int i);

    default void update() {
        System.out.println(i);
    }
}

class Manager implements User, Administrator {

    @Override
    public void add(int i) {
        System.out.println(User.i);
        System.out.println(Administrator.i);
    }

    @Override
    public void update() {
        Administrator.super.update();
        User.super.update();
    }

}