package com.pwk.springboot.study.hash;

public interface MySet<T> extends Iterable<T>{
    void clear();
    boolean contains(T t);
    boolean add(T t);
    boolean remove(T t);
    boolean isEmpty();
    int size();
}
