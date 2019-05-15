package com.pwk.springboot.study.design_pattern.builder;

public abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
