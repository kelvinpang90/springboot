package com.pwk.springboot.study.design_pattern.prototype;

public class Circle extends Shape {
    public Circle() {
        super.type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("draw Circle");
    }
}
