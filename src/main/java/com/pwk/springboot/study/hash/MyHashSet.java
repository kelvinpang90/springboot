package com.pwk.springboot.study.hash;

import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet<T> implements MySet<T> {

    private final static int DEFAULT_INITIAL_CAPACITY = 4;
    private final static int MAXIMUM_CAPACITY = 1<<30;
    private final static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    private int capacity;
    private float loadFactorThreshold;
    private int size = 0;
    private LinkedList<T>[] table;

    public MyHashSet(int capacity, float loadFactorThreshold) {
        if(capacity<MAXIMUM_CAPACITY)
            this.capacity = capacity;
        else
            this.capacity = MAXIMUM_CAPACITY;

        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];
    }

    public MyHashSet(int capacity) {
        this(capacity,DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashSet() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @Override
    public void clear() {
        removeElements();
        size = 0;
    }

    @Override
    public boolean contains(T t) {
        int bucketIndex = hash(t.hashCode());
        if(table[bucketIndex]!=null){
            LinkedList<T> bucket = table[bucketIndex];
            for(T value:bucket){
                if(value.equals(t))
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        if(contains(t)) return false;
        if(size>=capacity*loadFactorThreshold){
            if(capacity>=MAXIMUM_CAPACITY)
                throw new RuntimeException("exceeding maxium capacity");
        }
        rehash();
        int bucketIndex = hash(t.hashCode());
        if(table[bucketIndex]==null){
            table[bucketIndex] = new LinkedList<>();
        }
        table[bucketIndex].add(t);
        size++;
        return true;
    }

    @Override
    public boolean remove(T t) {
        if(!contains(t)) return false;
        int bucketIndex = hash(t.hashCode());
        LinkedList<T> bucket = table[bucketIndex];
        if(bucket !=null){
            for(T value:bucket){
                if(value.equals(t)) {
                    bucket.remove(t);
                    size--;
                    break;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<capacity;i++){
            if(table[i]!=null){
                LinkedList<T> bucket = table[i];
                for(T t:bucket){
                    sb.append(t).append(",");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void removeElements(){
        for(int i = 0;i<capacity;i++){
            if(table[i]!=null)
                table[i].clear();
        }
    }

    //ensure the hashing is evenly distributed
    private static int supplementalHash(int h){
        h ^= (h>>>20)^(h>>>12);
        return h^(h>>>7)^(h>>>4);
    }

    //散列函数和压缩散列码
    private int hash(int hashCode){
        return supplementalHash(hashCode)&(capacity-1);
    }

    private void rehash(){
        List<T> list = new ArrayList<>();
        for(int i = 0;i<capacity;i++){
            if(table[i]!=null){
                for(T t:table[i])
                    list.add(t);
            }
        }
        capacity<<=1; //same as capacity*=2;
        table = new LinkedList[capacity];
        for(T t:list)
            add(t);
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
