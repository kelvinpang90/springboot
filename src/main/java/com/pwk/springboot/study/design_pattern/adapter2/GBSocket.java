package com.pwk.springboot.study.design_pattern.adapter2;

public class GBSocket implements GBSocketInterface {
    @Override
    public void powerWithThreeRound() {
        System.out.println("GB socket power on");
    }
}
