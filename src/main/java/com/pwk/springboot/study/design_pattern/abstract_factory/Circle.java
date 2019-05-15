package com.pwk.springboot.study.design_pattern.abstract_factory;

public  class Circle implements Shape{

    @Override
    public void getShape() {
        System.out.println("Circle");
    }
}