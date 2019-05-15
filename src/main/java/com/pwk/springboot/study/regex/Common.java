package com.pwk.springboot.study.regex;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
    public static void main(String[] args){
        Console console = System.console();
        if(console == null){
            System.out.println("No console");
            System.exit(1);
        }
        while (true){
            Pattern pattern = Pattern.compile(console.readLine("Please enter your regex:"));
            Matcher matcher = pattern.matcher(console.readLine("Please enter your string:"));
            while(matcher.find()){
                System.out.println(matcher.matches());
//                System.out.format("Text found (%s),index start at %d and end at %d\n",matcher.group(),matcher.start(),matcher.end());
            }
            if(!matcher.find())
                System.out.println("Text not found");
        }
    }
}
