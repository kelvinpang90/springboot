package com.pwk.springboot.study.design_pattern.proxy;

public class ProxyImage implements Image {
    private Image image;

    @Override
    public void display() {
        image = new RealImage();
        System.out.println("using proxy...");
        image.display();
    }
}
