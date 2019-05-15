package com.pwk.springboot.study.collection;

public abstract class AbstractTree<T> implements Tree<T> {
    @Override
    public void inorder() {

    }

    @Override
    public void preorder() {

    }

    @Override
    public void postorder() {

    }

    @Override
    public boolean isEmpty() {
        return getSize()==0;
    }
}
