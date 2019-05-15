package com.pwk.springboot.study.design_pattern.builder;

public class VegBurger extends Burger {
    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public float price() {
        return 2.0f;
    }
}
