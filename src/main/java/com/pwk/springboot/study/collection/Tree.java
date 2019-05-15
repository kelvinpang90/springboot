package com.pwk.springboot.study.collection;

public interface Tree<T> extends Iterable<T>{
    boolean search(T t);
    boolean insert(T t);
    boolean delete(T t);
    void inorder();
    void preorder();
    void postorder();
    int getSize();
    boolean isEmpty();
}
