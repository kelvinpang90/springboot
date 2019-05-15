package com.pwk.springboot.study.design_pattern.builder;

public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "wrapper";
    }
}
