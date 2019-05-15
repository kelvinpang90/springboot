package com.pwk.springboot.study.collection;

import org.springframework.lang.NonNull;

import java.util.Iterator;

public class MyArrayList<T> extends MyAbstractList<T> {
    private T[] array = (T[]) new Object[16];

    public MyArrayList(T[] array) {
        if(array!=null&&array.length>0){
            for(int i = 0;i<array.length;i++){
                add(array[i]);
            }
        }
    }

    @Override
    public void add(int index,T t) {
        ensureCapacity();
        for(int i = size-1;i>=index;i--){
            array[i+1] = array[i];
        }
        array[index] = t;
        size++;
    }

    @Override
    public void clear() {
        array =  (T[]) new Object[16];
        size = 0;
    }

    @Override
    public boolean contains(T t) {
        for(int i = 0;i<array.length;i++){
            if(array[i].equals(t))
                return true;
        }
        return false;
    }

    @Override
    public T get(int index) {
        if(index<0||index>=size-1){
            throw new IndexOutOfBoundsException("index "+index+" out of bounds");
        }
        return array[index];
    }

    @Override
    public int indexOf(T t) {
        for(int i = 0;i<array.length;i++){
            if(array[i].equals(t))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T t) {
        for(int i = size-1;i>0;i--){
            if(array[i].equals(t))
                return i;
        }
        return 0;
    }

    @Override
    public T remove(int index) {
        if(index<0||index>=size-1){
            throw new IndexOutOfBoundsException("index "+index+" out of bounds");
        }
        T t = array[index];
        for(int i = index;i<size-1;i++){
            array[i] = array[i+1];
        }
        array[size-1] = null;
        size--;
        return t;
    }

    @Override
    public T set(int index,T t) {
        if(index<0||index>=size-1){
            throw new IndexOutOfBoundsException("index "+index+" out of bounds");
        }
        T oldData= array[index];
        array[index] = t;
        return oldData;
    }

    public void trimToSize(){
        if(array.length!=size){
            T[] newArray = (T[]) new Object[size];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }
    }


    @Override
    @NonNull
    public Iterator<T> iterator() {
        return null;
    }

    private void ensureCapacity(){
        if(size>=array.length-1){
            T[] newArray = (T[]) new Object[size*2+1];
            System.arraycopy(array,0,newArray,0,array.length);
            array = newArray;
        }
    }


    class MyArrayListIterator<T> implements Iterator{

        private int current = 0;
        @Override
        public boolean hasNext() {
            return current<size;
        }

        @Override
        public T next() {
            return (T) array[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        for(int i = 0;i<size;i++){
            list.append(array[i]);
            if(i<size-1)
                list.append(",");
        }
        return "MyArrayList{" +
                "array=" + list +
                '}';
    }
}


