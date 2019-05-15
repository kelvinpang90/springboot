package com.pwk.springboot.study.design_pattern.facade;

public class Test {
    public static void main(String[] args){
        ShapeMaker shapeMaker = new ShapeMaker(new Circle(),new Rectangle(),new Square());
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();

    }
}
