package com.pwk.springboot.study.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args){
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
    }
    interface IHello{
        void sayHello();
    }
    static class Hello implements IHello{

        @Override
        public void sayHello() {
            System.out.println("Say Hello");
        }
    }

    static class DynamicProxy implements InvocationHandler{

        private Object obj;

        Object bind(Object obj){
            this.obj = obj;
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Welcome");
            return method.invoke(obj,args);
        }
    }
}
