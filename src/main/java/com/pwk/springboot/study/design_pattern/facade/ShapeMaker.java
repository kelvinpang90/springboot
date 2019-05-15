package com.pwk.springboot.study.design_pattern.facade;

public class ShapeMaker{
    private Circle circle;
    private Rectangle rectangle;
    private Square square;

    public ShapeMaker(Circle circle, Rectangle rectangle, Square square) {
        this.circle = circle;
        this.rectangle = rectangle;
        this.square = square;
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRectangle(){
        rectangle.draw();
    }

    public void drawSquare(){
        square.draw();
    }
}
