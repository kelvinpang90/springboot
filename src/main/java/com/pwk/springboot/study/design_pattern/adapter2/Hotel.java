package com.pwk.springboot.study.design_pattern.adapter2;

public class Hotel {
    private DBSocketInterface dbSocketInterface;

    public Hotel() {
    }

    public Hotel(DBSocketInterface dbSocketInterface) {
        this.dbSocketInterface = dbSocketInterface;
    }

    public void setDbSocketInterface(DBSocketInterface dbSocketInterface) {
        this.dbSocketInterface = dbSocketInterface;
    }
    public void charge(){
        dbSocketInterface.powerWithTwoRound();
    }
}
