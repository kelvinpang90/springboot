package com.pwk.springboot.study.design_pattern.builder;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 0.5f;
    }
}
