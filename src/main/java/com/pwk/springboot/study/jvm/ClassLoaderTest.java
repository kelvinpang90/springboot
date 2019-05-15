package com.pwk.springboot.study.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

//Use instanceof and overriding function ClassLoader.loadClass() to examine different ClassLoader
//通过重写loadClass方法，证明不同的类加载器加载的类肯定不一样，测试instanceof验证
public class ClassLoaderTest {
    static ClassLoader classLoader = new ClassLoader() {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            try {
                String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if(is == null)
                return super.loadClass(name);
                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name,b,0,b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object obj = classLoader.loadClass("com.reborn.test.jvm.ClassLoaderTest").getConstructor().newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);
    }
}
