package com.pwk.springboot.study.collection;

import java.util.*;

public class List_vs_Set {
    private final static int N=50000;
    public static void main(String[] args){
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i<N;i++)
            arrayList.add(i);
        List<Integer> linkedList = new LinkedList<>(arrayList);
        Set<Integer> hashSet = new HashSet<>(arrayList);
        Set<Integer> linkedHashSet = new LinkedHashSet<>(arrayList);
        Set<Integer> treeSet = new TreeSet<>(arrayList);

        System.out.println("arrayList="+testSearch(arrayList));
        System.out.println("linkedList="+testSearch(linkedList));
        System.out.println("hashSet="+testSearch(hashSet));
        System.out.println("linkedHashSet="+testSearch(linkedHashSet));
        System.out.println("treeSet="+testSearch(treeSet));

        System.out.println("arrayList="+testRemove(arrayList));
        System.out.println("linkedList="+testRemove(linkedList));
        System.out.println("hashSet="+testRemove(hashSet));
        System.out.println("linkedHashSet="+testRemove(linkedHashSet));
        System.out.println("treeSet="+testRemove(treeSet));

    }

    public static long testSearch(Collection c){
        long startTime = System.currentTimeMillis();
        for(int i=0;i<=N;i++)
            c.contains((int)(Math.random()*2*N));
        return System.currentTimeMillis()-startTime;
    }

    public static long testRemove(Collection c){
        long startTime = System.currentTimeMillis();
        for(int i =0;i<N;i++)
            c.remove(i);
        return System.currentTimeMillis()-startTime;
    }
}
