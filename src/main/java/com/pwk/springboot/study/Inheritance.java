package com.pwk.springboot.study;

public class Inheritance {

    public static void main(String[] args){
        int a = 10; int b = 20;
        My_Calculation c = new My_Calculation();
        c.multiplication(a,b);
    }
}

class Calculation{
    public Calculation() {
        System.out.println("construct Calculation");
    }

    int z;

    public void addition(int x, int y) {
        z = x + y;
        System.out.println("The sum of the given numbers:"+z);
    }

    public void subtraction(int x, int y) {
        z = x - y;
        System.out.println("The difference between the given numbers:"+z);
    }
}

class My_Calculation extends Calculation{

    public My_Calculation() {
        super();
        System.out.println("construct My Calculation");
    }

    public void multiplication(int x, int y){
        super.addition(x,y);
        super.subtraction(x,y);
        z = x*y;
        System.out.println("The product of the given numbers:"+z);
    }
}