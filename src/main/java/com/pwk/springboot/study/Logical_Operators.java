package com.pwk.springboot.study;

public class Logical_Operators {
    public static void main(String[] args){
        /**
         * & and &&
         * & right size will execute either left side is true or false
         * && right side will execute as long as left size is ture
         */
        int j = 1;
        if(j++>1&&j++<3){
            System.out.println(j);
        }
        System.out.println(j);
    }
}
