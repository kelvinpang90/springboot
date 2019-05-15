package com.pwk.springboot.study.thread;

import com.pwk.springboot.study.sort.Merge;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

public class Fork_Join_MergeSort {

    public static void main(String[] args){
        int[] list1 = new int[70000];
        int[] list2 = new int[70000];
        int[] list3 = new int[70000];
        for(int i = 0;i<70000;i++){
            list1[i]=list2[i] = list3[i] = (int)(Math.random()*10000000);
        }

        //普通排序
        long start = System.currentTimeMillis();
        Arrays.sort(list1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        //递归排序
        List<Integer> tempList = Arrays.stream(list2).boxed().collect(Collectors.toList());
        start = System.currentTimeMillis();
        Merge.sort(tempList);
        end = System.currentTimeMillis();
        System.out.println(end-start);

        //fork/join排序
        start = System.currentTimeMillis();
        parallelMerge(list3);
        end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void parallelMerge(int[] list){
        RecursiveAction task = new SortTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

    }

    private static class SortTask extends RecursiveAction{
        private int[] list;

        public SortTask(int[] list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if(list.length<50000)
                Arrays.sort(list);
            else{
                int[] firstHalf = new int[list.length/2];
                System.arraycopy(list,0,firstHalf,0,list.length/2);
                int[] secondHalf = new int[list.length-list.length/2];
                System.arraycopy(list,list.length/2,secondHalf,0,list.length-list.length/2);

                invokeAll(new SortTask(firstHalf),new SortTask(secondHalf));

                Merge.merge(Arrays.stream(firstHalf).boxed().collect(Collectors.toList()),Arrays.stream(secondHalf).boxed().collect(Collectors.toList()));
            }
        }
    }
}
