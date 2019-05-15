package com.pwk.springboot.study.design_pattern.bridge;

public class RedCircle implements DrawAPI {

    @Override
    public void draw(int x, int y, int radius) {
        System.out.println("RedCircle:x="+x+" y="+y+" radius="+radius);
    }
}
