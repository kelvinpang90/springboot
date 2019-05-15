package com.pwk.springboot.study.sort;

import java.util.List;

public class Bubble {
    public static void sort(List<Integer> unsortedList){
        for(int i = 1;i<unsortedList.size();i++){
            for(int j = 0;j<unsortedList.size()-i;j++){
                if(unsortedList.get(j)>unsortedList.get(j+1)){
                    int swap = unsortedList.get(j);
                    unsortedList.set(j,unsortedList.get(j+1));
                    unsortedList.set(j+1,swap);
                }
            }
        }
        System.out.println(unsortedList);
    }
}
