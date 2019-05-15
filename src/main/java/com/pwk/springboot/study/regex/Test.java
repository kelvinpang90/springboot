package com.pwk.springboot.study.regex;

import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args){
        while(true){
            Pattern pattern = Pattern.compile(System.console().readLine("input REGEX:"));
            String[] strings = pattern.split(System.console().readLine("input string:"));
            for(String str:strings){
                System.out.println(str);
            }
        }
    }
}
