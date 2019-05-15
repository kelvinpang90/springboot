package com.pwk.springboot.study.design_pattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class ShapeCache {
    private static Map<Integer,Shape> shapes = new HashMap<>();

    public static void createCache(){
        Circle circle = new Circle();
        circle.setId(1);
        shapes.put(1,circle);

        Square square = new Square();
        square.setId(2);
        shapes.put(2,square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId(3);
        shapes.put(3,rectangle);
    }

    public static Shape getShape(int id){
        Shape shape = shapes.get(id);
        return (Shape) shape.clone();
    }


}
