package com.pwk.springboot.study.design_pattern.adapter2;

public class Test {
    public static void main(String[] args){
        GBSocketInterface gbSocketInterface = new GBSocket();
        Hotel hotel = new Hotel();
        SocketAdapter socketAdapter = new SocketAdapter(gbSocketInterface);
        hotel.setDbSocketInterface(socketAdapter);
        hotel.charge();
    }
}
