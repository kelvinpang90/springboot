package com.pwk.springboot.study.jvm;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String className = name.substring(name.lastIndexOf(".") + 1) + ".class";
        System.out.println("className="+name);
        InputStream inputStream = getClass().getResourceAsStream(name);
        if (inputStream == null)
            throw new ClassNotFoundException();
        try {
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Object obj = myClassLoader.loadClass("java.lang.String").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof String);
    }
}
