package com.pwk.springboot.study.multi_threading.fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {
    private final static int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end-start)<=THRESHOLD;
        if(canCompute){
            for(int i = start;i<=end;i++)
                sum += i;
        }else{
            //根据条件继续分解任务
            int middle = (start+end)/2;
            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle+1,end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //合并子任务
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并结果
            sum = leftResult+rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //新建任务
        CountTask task = new CountTask(1,50000000);
        //执行任务
        Future<Integer> result = forkJoinPool.submit(task);
        if(task.isCompletedAbnormally())
            System.out.println(task.getException());
        System.out.println(result.get());
        long endTime = System.currentTimeMillis();
        System.out.println("time consumption:"+(endTime-startTime));

        //单线程加法
        startTime = System.currentTimeMillis();
        System.out.println(sum(1,50000000));
        endTime = System.currentTimeMillis();
        System.out.println("time consumption:"+(endTime-startTime));
    }

    public static int sum(int start,int end){
        int sum = 0;
        for(int i = start;i<=end;i++){
            sum += i;
        }
        return sum;
    }
}
