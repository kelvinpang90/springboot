package com.pwk.springboot.study.sort;

import java.util.List;

public class Quick {
    public static void sort(List<Integer> unsortedList){
        quickSort(unsortedList,0,unsortedList.size()-1);
        System.out.println(unsortedList);
    }

    public static void quickSort(List<Integer> unsortedList,int firstIndex, int lastIndex){
        if(firstIndex<lastIndex){
            int pivotIndex = partition(unsortedList,firstIndex,lastIndex);
            quickSort(unsortedList,firstIndex,pivotIndex-1);
            quickSort(unsortedList,pivotIndex+1,lastIndex);
        }
    }

    public static int partition(List<Integer> unsortedList,int firstIndex, int lastIndex){
        int pivot = unsortedList.get(firstIndex);
        int lowIndex = firstIndex+1;
        int highIndex = lastIndex;

        //iterate list except pivot
        while (highIndex>lowIndex){
            //search element which greater than pivot
            while(lowIndex<=highIndex&&unsortedList.get(lowIndex)<=pivot)
                lowIndex++;
            //search element which less than or equal pivot
            while ((lowIndex<=highIndex&&unsortedList.get(highIndex)>pivot))
                highIndex--;

            if(highIndex>lowIndex){
                int temp = unsortedList.get(highIndex);
                unsortedList.set(highIndex,unsortedList.get(lowIndex));
                unsortedList.set(lowIndex,temp);
            }
        }

        //find the proper index to place pivot
        while(firstIndex>highIndex&&pivot<unsortedList.get(highIndex))
            highIndex--;

        //if all elements are greater than pivot, use the same pivot for next recursion, or return the new pivot which replaced the old pivot
        if(pivot>unsortedList.get(highIndex)){
            unsortedList.set(firstIndex,unsortedList.get(highIndex));
            unsortedList.set(highIndex,pivot);
            return highIndex;
        }else{
            return firstIndex;
        }
    }
}
