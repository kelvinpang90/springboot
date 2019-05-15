package com.pwk.springboot.study.design_pattern.builder;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "ChickenBurger";
    }

    @Override
    public float price() {
        return 3.0f;
    }
}
