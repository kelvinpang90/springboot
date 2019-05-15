package com.pwk.springboot.study.design_pattern.bridge;

public class Circle extends Shape {

    private int x,y,radius;

    public Circle(DrawAPI drawAPI,int x,int y,int radius) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.draw(x,y,radius);
    }
}