package com.pwk.springboot.study.design_pattern.bridge;

public class Test {
    public static void main(String[] args){
        Shape circle = new Circle(new RedCircle(),1,2,3);
        circle.draw();

        Shape circle1 = new Circle(new GreenCircle(),2,3,4);
        circle1.draw();
    }
}
