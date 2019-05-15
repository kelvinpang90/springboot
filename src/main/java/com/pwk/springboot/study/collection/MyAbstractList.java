package com.pwk.springboot.study.collection;

public abstract class MyAbstractList<T> implements MyList<T> {
    protected int size = 0;
    @Override
    public void add(T t) {
        add(size,t);
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean remove(T t) {
        if(indexOf(t)>=0){
            remove(indexOf(t));
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
