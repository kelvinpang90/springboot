package com.pwk.springboot.study;

public class Char {
    public static void main(String[] args){
        char[] c = {'a','b','c','d','e','f'};
        char[] d = {'a','b','c','d','e','f'};
        String str = new String(c);
        String str1 = new String(d);
        System.out.println(str.concat(str1));

        System.out.println(str.indexOf("b"));
        System.out.println(str.lastIndexOf("b"));

        System.out.println(str.equals(str1));

        System.out.println(reverse(str));

        StringBuilder stringBuilder = new StringBuilder(16);
    }

    public static String reverse(String src){
        byte[] dest = src.getBytes();
        int length = src.length();
        int n = length-1;
        for(int i=(n-1)>>1;i>=0;i--){
            int k = n-i;
            byte temp = dest[i];
            dest[i] = dest[k];
            dest[k] = temp;
        }
        return new String(dest);
    }
}
