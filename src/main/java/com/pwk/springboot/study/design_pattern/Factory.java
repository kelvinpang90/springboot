package com.pwk.springboot.study.design_pattern;

public class Factory {
    interface Shape{void draw();}
    static class Square implements Shape{

        @Override
        public void draw() {
            System.out.println("draw Square");
        }
    }
    static class Circle implements Shape{

        @Override
        public void draw() {
            System.out.println("draw Circle");
        }
    }

    static class Rectangle implements Shape{

        @Override
        public void draw() {
            System.out.println("draw Rectangle");
        }
    }

    static Shape getShape(String shape){
        if(shape.equalsIgnoreCase("square"))
            return new Square();
        if(shape.equalsIgnoreCase("circle"))
            return new Circle();
        if(shape.equalsIgnoreCase("rectangle"))
            return new Rectangle();
        return null;
    }

    public static void main(String[] args){
        Shape shape = Factory.getShape("square");
        shape.draw();
    }
}
