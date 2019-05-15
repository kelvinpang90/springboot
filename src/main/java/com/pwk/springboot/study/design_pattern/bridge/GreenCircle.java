package com.pwk.springboot.study.design_pattern.bridge;

public class GreenCircle implements DrawAPI {
    @Override
    public void draw(int x, int y, int radius) {
        System.out.println("GreenCircle:x="+x+" y="+y+" radius="+radius);
    }
}
