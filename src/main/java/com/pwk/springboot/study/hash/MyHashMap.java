package com.pwk.springboot.study.hash;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyHashMap<K,V> implements MyMap<K,V> {
    //must be the power of 2
    private final static int DEFAULT_INITIAL_CAPACITY = 4;
    //1<<30 same as 2^30
    private final static int MAX_CAPACITY = 1<<30;
    //max load factor
    private final static float MAX_LOAD_FACTOR = 0.75f;

    private int capacity;

    private float load_factor_threshold;

    private int size = 0;

    private LinkedList<Entry<K,V>>[] table;

    public MyHashMap(int capacity, float load_factor_threshold) {
        if(capacity>MAX_CAPACITY)
            this.capacity = MAX_CAPACITY;
        else
            this.capacity = trimToPowerOf2(capacity);
        this.load_factor_threshold = load_factor_threshold;

        table = new LinkedList[capacity];
    }

    public MyHashMap(int capacity) {
        this(capacity,MAX_LOAD_FACTOR);
    }

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY,MAX_LOAD_FACTOR);
    }

    @Override
    public void clear() {
        removeEntries();
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> entrySet = new HashSet<>();
        for(int i = 0;i<capacity;i++){
            if(table[i]!=null){
                LinkedList<Entry<K,V>> bucket = table[i];
                entrySet.addAll(bucket);
            }
        }
        return entrySet;
    }

    /**
     * 根据散列码，找到在散列表中相对的位置。然后遍历存储在对应位置的LinkList，找到对应的Entry，返回Value
     * @param key that to be located
     * @return value if found, null if not found
     */
    @Override
    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        if(table[bucketIndex]!=null){
            LinkedList<Entry<K,V>> bucket = table[bucketIndex];
            for(Entry<K,V> entry:bucket){
                if(entry.equals(key))
                    return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        //if entry already existed, replace the old value to new value
        if(get(key)!=null){
            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<K,V>> bucket = table[bucketIndex];
            for(Entry<K,V> entry:bucket){
                if(entry.getKey().equals(key)){
                    V oldValue= entry.getValue();
                    entry.value = value;
                    return oldValue;
                }
            }
        }

        //check whether exceed max capacity
        if(size>=capacity*load_factor_threshold){
            if(size>=MAX_CAPACITY)
                throw new RuntimeException("exceed maximum capacity");
            rehash();
        }

        int bucketIndex = hash(key.hashCode());

        if(table[bucketIndex]==null)
            table[bucketIndex] = new LinkedList<>();

        table[bucketIndex].add(new Entry<>(key,value));
        size++;
        return value;
    }

    @Override
    public void remove(K key) {
        int bucketIndex = hash(key.hashCode());
        if(table[bucketIndex]!=null){
            LinkedList<Entry<K,V>> bucket = table[bucketIndex];
            for(Entry<K,V> entry:bucket){
                if(entry.getKey().equals(key)){
                    bucket.remove(entry);
                    size--;
                    break;
                }
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<V> values() {
        Set<V> values = new HashSet<>();
        for(int i = 0;i<capacity;i++){
            if(table[i]!=null){
                LinkedList<Entry<K,V>> bucket = table[i];
                for(Entry<K,V> entry:bucket)
                    values.add(entry.getValue());
            }
        }
        return values;
    }

    @Override
    public String toString() {
        return entrySet().toString();
    }

    //remove all entries
    private void removeEntries(){
        for(int i = 0;i<capacity;i++){
            if(table[i]!= null)
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

    //return capacity is the power of 2
    private int trimToPowerOf2(int initialCapacity){
        int capacity = 1;
        while(capacity<initialCapacity){
            capacity <<=1; //same as capacity *= 2;
        }
        return capacity;
    }

    //enlarge the capacity of table to double size
    private void rehash(){
        Set<Entry<K,V>> entrySet = entrySet();
        capacity<<=1; //same as capacity*=2;
        table = new LinkedList[capacity];
        size = 0;
        for(Entry<K,V> entry:entrySet){
            put(entry.getKey(),entry.getValue());
        }
    }
}
