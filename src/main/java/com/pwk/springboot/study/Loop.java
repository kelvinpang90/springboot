package com.pwk.springboot.study;

public class Loop {
    public static void main(String[] args){
        int i;

        String[] str = new String[]{"a","b","c"};

        for( i = 0;i<=10;i++){
            if(i==3)continue;
            if(i==5) break;
        }

        for(String s:str){
            System.out.println(s);
        }

        while(i>=0){
            i--;

        }

        do{
            i++;
        }while(i<10);
        System.out.println(Static.test("abc"));
    }
}
