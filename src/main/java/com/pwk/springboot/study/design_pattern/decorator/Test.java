package com.pwk.springboot.study.design_pattern.decorator;

public class Test {
    public static void main(String[] args){
        Shape shape = new RedShapeDecorator(new Circle());
        shape.draw();
    }
}