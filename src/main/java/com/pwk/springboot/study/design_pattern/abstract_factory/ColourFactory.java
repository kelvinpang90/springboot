package com.pwk.springboot.study.design_pattern.abstract_factory;

public class ColourFactory extends AbstractFactory{

    @Override
    Shape getShape(String shape) {
        return null;
    }

    @Override
    Colour getColour(String colour) {
        if(colour.equalsIgnoreCase("red"))
            return new Red();
        if(colour.equalsIgnoreCase("green"))
            return new Green();
        if(colour.equalsIgnoreCase("yellow"))
            return new Yellow();
        return null;
    }
}
