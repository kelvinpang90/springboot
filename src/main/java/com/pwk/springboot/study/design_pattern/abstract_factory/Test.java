package com.pwk.springboot.study.design_pattern.abstract_factory;

public class Test {
    public static void main(String[] args){
        AbstractFactory colourFactory = FactoryProducer.getFactory("colour");
        colourFactory.getColour("red").getColour();

        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        shapeFactory.getShape("circle").getShape();
    }
}
