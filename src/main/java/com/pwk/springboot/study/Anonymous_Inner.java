package com.pwk.springboot.study;

public class Anonymous_Inner {
    interface HelloWorld{
         public void sayHello();
         public void sayHelloTo(String name);
    }

    public void sayHello(){
        //局部类
        class EnglishGreeting implements HelloWorld{

            @Override
            public void sayHello() {
                System.out.println("hello world");
            }

            @Override
            public void sayHelloTo(String name) {
                System.out.println("hello "+name);
            }
        }

        HelloWorld englighGreeting = new EnglishGreeting();

        //匿名类
        HelloWorld frenchGreeting = new HelloWorld() {
            @Override
            public void sayHello() {
                System.out.println("Tout Le Monde");
            }

            @Override
            public void sayHelloTo(String name) {
                System.out.println("Salut "+name);
            }
        };

        englighGreeting.sayHello();
        frenchGreeting.sayHello();
    }

    public static void main(String[] args){
        Anonymous_Inner anonymous_inner = new Anonymous_Inner();
        anonymous_inner.sayHello();
    }
}
