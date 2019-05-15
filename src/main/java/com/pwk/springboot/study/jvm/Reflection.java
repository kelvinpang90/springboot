package com.pwk.springboot.study.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象
        Class klass = Class.forName("java.lang.String");
        System.out.println(klass.getName());

        //判断类实例
        System.out.println(new String() instanceof String);

        //创建实例
        Constructor[] constructors = klass.getConstructors();
        for(Constructor constructor:constructors){
            Parameter[] parameters = constructor.getParameters();
            for(Parameter parameter:parameters){
                System.out.print(parameter.getType());
            }
            System.out.println();
        }

        //
        Method[] methods = klass.getMethods();
        for(Method method:methods)
            System.out.println(method.getName());

        klass.getFields();
    }

}
