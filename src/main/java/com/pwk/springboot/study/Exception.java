package com.pwk.springboot.study;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exception {
    public static void main(String[] args) throws IOException {
        //try-with-resources
        try(
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\pengw\\Desktop\\java note.txt"));

        ){
            System.out.println(br.readLine());
        }
        throw new IOException();
    }
}
