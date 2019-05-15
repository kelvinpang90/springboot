package com.pwk.springboot.study.design_pattern.adapter2;

public class DBSocket implements DBSocketInterface {
    @Override
    public void powerWithTwoRound() {
        System.out.println("DB socket power on");
    }
}
