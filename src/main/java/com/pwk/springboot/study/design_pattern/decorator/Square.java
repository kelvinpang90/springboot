package com.pwk.springboot.study.design_pattern.decorator;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("draw Square");
    }
}
