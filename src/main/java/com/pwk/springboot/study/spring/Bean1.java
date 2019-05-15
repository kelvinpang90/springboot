package com.pwk.springboot.study.spring;

import java.util.List;

public class Bean1 {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNum;
    private List<String> list;

    public Bean1(int id, String name, String email, String address, String phoneNum, List<String> list) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.list = list;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return id+" "+name+" "+email+" "+address+" "+phoneNum+" "+list;
    }
}
