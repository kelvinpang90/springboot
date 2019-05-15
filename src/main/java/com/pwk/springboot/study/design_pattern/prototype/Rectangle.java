package com.pwk.springboot.study.design_pattern.prototype;

public class Rectangle extends Shape {
    public Rectangle() {
        super.type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("draw Rectangle");
    }
}
