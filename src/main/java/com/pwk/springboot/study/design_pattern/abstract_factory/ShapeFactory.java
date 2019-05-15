package com.pwk.springboot.study.design_pattern.abstract_factory;

public class ShapeFactory extends AbstractFactory{
    @Override
    Shape getShape(String shape) {
        if(shape.equalsIgnoreCase("circle"))
            return new Circle();
        if (shape.equalsIgnoreCase("square"))
            return new Square();
        if(shape.equalsIgnoreCase("rectangle"))
            return new Rectangle();
        return null;
    }

    @Override
    Colour getColour(String colour) {
        return null;
    }
}
