package com.pwk.springboot.study.design_pattern.abstract_factory;

public class FactoryProducer {
    static AbstractFactory getFactory(String factory){
        if(factory.equalsIgnoreCase("shape"))
            return new ShapeFactory();
        if (factory.equalsIgnoreCase("colour"))
            return new ColourFactory();
        return null;
    }
}
