package com.pwk.springboot.study.design_pattern.prototype;

public class Square extends Shape {
    public Square() {
        super.type = "Square";
    }

    @Override
    void draw() {
        System.out.println("draw Square");
    }
}
