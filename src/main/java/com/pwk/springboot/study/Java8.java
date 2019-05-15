package com.pwk.springboot.study;

import java.lang.reflect.*;

public class Java8 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        String str = "";
        System.out.println(str.getClass());
        Class clazz = str.getClass();
        String string = (String)clazz.getConstructor(String.class).newInstance("abc");
//        String string = (String)clazz.getConstructors()[3].newInstance(String.class,"abc");
        Method  method = clazz.getMethod("length");
        System.out.println(method.invoke(string));

        clazz = Class.forName("java.lang.String");
        Object obj = Array.newInstance(clazz,20);
        Array.set(obj,0,"abc");
        System.out.println(Array.get(obj,0));

        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constructor:constructors){
            System.out.print(constructor.getName()+" ");
            Parameter[] parameters = constructor.getParameters();
            for(Parameter parameter:parameters){
                System.out.print(parameter.getName()+"("+parameter.getType()+")"+" ");
            }
            System.out.println();
        }
        System.out.println(str instanceof String);
    }
}
