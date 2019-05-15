package com.pwk.springboot.study.design_pattern.decorator;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw Circle");
    }
}
