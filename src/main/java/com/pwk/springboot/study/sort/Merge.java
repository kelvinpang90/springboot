package com.pwk.springboot.study.sort;

import java.util.ArrayList;
import java.util.List;

public class Merge {
    public static void sort(List<Integer> unsortedList){
        divide(unsortedList);
    }

    //divide list
    public static void divide(List<Integer> unsortedList){
        if(unsortedList.size()>1){
            List<Integer> firstHalf = unsortedList.subList(0,unsortedList.size()/2);
            divide(firstHalf);

            List<Integer> secondHalf = unsortedList.subList(unsortedList.size()/2,unsortedList.size());
            divide(secondHalf);
            merge(firstHalf,secondHalf);
        }
    }

    public static void merge(List<Integer> firstHalf,List<Integer> secondHalf){
        int currentList1 = 0;
        int currentList2 = 0;
        List<Integer> tempList = new ArrayList<>();
        //tempList index
        while(currentList1<firstHalf.size()&&currentList2<secondHalf.size()){
            if(firstHalf.get(currentList1)<secondHalf.get(currentList2))
                tempList.add(firstHalf.get(currentList1++));
            else
                tempList.add(secondHalf.get(currentList2++));
        }

        while(currentList1<firstHalf.size())
            tempList.add(firstHalf.get(currentList1++));
        while ((currentList2<secondHalf.size()))
            tempList.add(secondHalf.get(currentList2++));
    }
}
