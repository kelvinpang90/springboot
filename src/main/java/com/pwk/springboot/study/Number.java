package com.pwk.springboot.study;

import java.text.DecimalFormat;
import java.util.Calendar;

public class Number {
    public static void main(String[] args){
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
//
        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

        int i = 123456789;
        System.out.format("i is %d%n",i);
        double pi = Math.PI;
        System.out.format("i is %f",pi).println();

        Calendar c = Calendar.getInstance();
        System.out.format("%tB,%te,%tY,%tl:%tM,%tp",c,c,c,c,c,c).println();
        System.out.format("%tD",c).println();

        DecimalFormat formater = new DecimalFormat("$###,###,###.##");
        System.out.println(formater.format(123456789.12));

        //向上取整
        System.out.println(Math.ceil(123.55));
        //向下取整
        System.out.println(Math.floor(123.55));
        //取最接近的整数
        System.out.println(Math.rint(123.49));

        System.out.println(0.99999999f==1f );

        System.out.println(Math.random());

        System.out.format("%f,%1$+020.10f %n",Math.PI);
    }
}
