package com.pwk.springboot.study.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.google.com");
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getAddress());
    }
}

