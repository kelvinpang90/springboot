package com.pwk.springboot.study.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Dynamic {
    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis()!=0?System.out:new StringBuilder();
        //传入参数，调用方法
        getPrintlnMH(obj).invokeExact("icyfenix");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        //定义被调用的方法返回类型为void，传入参数为string，然后生成该方法的对象
        MethodType mt = MethodType.methodType(void.class,String.class);
        //传入方法所在的对象，方法的名字，方法的类型，然后生成方法的句柄
        return MethodHandles.lookup().findVirtual(receiver.getClass(),"println",mt).bindTo(receiver);
    }
}
