package com.pwk.springboot.study.design_pattern.abstract_factory;

public class Red implements Colour{
    @Override
    public void getColour() {
        System.out.println("red");
    }
}