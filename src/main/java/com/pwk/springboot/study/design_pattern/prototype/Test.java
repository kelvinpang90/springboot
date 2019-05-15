package com.pwk.springboot.study.design_pattern.prototype;

public class Test {
    public static void main(String[] args){
        ShapeCache.createCache();
        Shape shape = ShapeCache.getShape(1);
        System.out.println(shape.type);
    }
}
