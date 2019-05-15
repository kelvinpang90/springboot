package com.pwk.springboot.study.hash;

import java.util.Set;

public interface MyMap<K,V> {
    void clear();
    boolean containsKey(K key);
    Set<Entry<K,V>> entrySet();
    V get(K key);
    boolean isEmpty();
    V put(K key, V value);
    void remove(K key);
    int size();
    Set<V> values();

    class Entry<K,V>{
         K key;
         V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "["+key+","+value+"]";
        }
    }
}
