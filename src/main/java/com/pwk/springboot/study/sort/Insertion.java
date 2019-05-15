package com.pwk.springboot.study.sort;

import java.util.List;

public class Insertion {
    public static void sort(List<Integer> unsortedList){
        for(int i = 1;i<unsortedList.size();i++){
            int currentElement = unsortedList.get(i);
            int j;
            /**
             * 从第二个元素i开始,分别跟之前的每个元素(0 to i-1,assume j)对比
             * 直到对比到j>i,则将j移动到j+1,对比直到第一个元素为止
             * 将i插入到位置j+1中
             */
            for( j = i-1;j>=0&&unsortedList.get(j)>currentElement;j--){
                unsortedList.set(j+1,unsortedList.get(j));
            }
            unsortedList.set(j+1,currentElement);
        }
        System.out.println(unsortedList);
    }
}
