package com.pwk.springboot.study.design_pattern.builder;

public class Bottle implements Packing {
    @Override
    public String pack() {
        return "bottle";
    }
}
