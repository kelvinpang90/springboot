package com.pwk.springboot.study.sort;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(-44);
        unsortedList.add(-5);
        unsortedList.add(-3);
        unsortedList.add(3);
        unsortedList.add(3);
        unsortedList.add(1);
        unsortedList.add(-4);
        unsortedList.add(0);
        unsortedList.add(1);
        unsortedList.add(2);
        unsortedList.add(4);
        unsortedList.add(5);
        unsortedList.add(53);

//        Insertion.sort(unsortedList);
//        Bubble.sort(unsortedList);
        Merge.sort(unsortedList);
//        Quick.sort(unsortedList);
//        HeapSort.sort(unsortedList);
    }
}
