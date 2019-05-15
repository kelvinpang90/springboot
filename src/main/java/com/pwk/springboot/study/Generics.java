package com.pwk.springboot.study;

import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args){
        //without generics
        List list = new ArrayList();
        list.add("hello");
        String s = (String) list.get(0);

        //with generics
        List<String> list1 = new ArrayList<>();
        list1.add("hello");
        String s1 = list1.get(0);

        Example<Integer,String> e1 = new Example<>();
        Example<Integer,String> e2 = new Example<>();

        e1.set(1,"a");
        e2.set(2,"b");
        String str = e1.getValue();
        System.out.println(str);

        System.out.println(compare(e1,e2));

        //上界通配符和下界通配符的使用
        process(new ArrayList<>());
        process1(new ArrayList<CharSequence>());
//        process(new ArrayList<String>());
        Example2<String> e3 = new Example2<>();
        e3.compareTo("");
    }
    //generics method
    public static <K extends java.lang.Number,V extends String> boolean compare(Example<K,V> e1, Example<K,V> e2){
        return e1.getKey().equals(e2.getKey())&&e1.getValue().equals(e2.getValue());
    }

    //wildcard
    public static void process(List<? extends java.lang.Number> list){
    }

    public static void process1(List<? super String> list){

    }
}

//generics class
class Example<K extends java.lang.Number,V extends String>{
    private K k;

    private V v;

    public V getValue() {
        return v;
    }

    public K getKey(){
        return k;
    }

    public void set(K k,V v) {
        this.k = k;
        this.v = v;
    }

}

class Example2<T> implements Comparable{

    @Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }
}
