package com.pwk.springboot.study;

@FunctionalInterface
public interface FunctionalInterfaceTest<T> {
    int compare(T o1, T o2);
}
