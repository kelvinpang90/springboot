package com.pwk.springboot.study.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Radix {
    public static void sort(List<Integer> list){
        Map<Integer,List<Integer>> buckets = new HashMap<>();
        for(int i = 0;i<9;i++)
            buckets.put(i,new ArrayList<>());

        for(Integer integer:list){

        }
    }
}
