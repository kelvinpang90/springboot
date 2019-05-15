package com.pwk.springboot.study.design_pattern.proxy;

public class RealImage implements Image {
    @Override
    public void display() {
        System.out.println("display Real Image");
    }
}
