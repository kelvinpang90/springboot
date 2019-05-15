package com.pwk.springboot.study.collection;

public interface MyList<T> extends Iterable<T> {

    void add(T t);

    void add(int index, T t);

    void clear();

    boolean contains(T t);

    T get(int index);

    int indexOf(T t);

    boolean isEmpty();

    int lastIndexOf(T t);

    boolean remove(T t);

    int size();

    T remove(int index);

    T set(int index, T t);
}
