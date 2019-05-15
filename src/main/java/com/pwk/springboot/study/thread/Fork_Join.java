package com.pwk.springboot.study.thread;

import java.util.concurrent.RecursiveTask;

public class Fork_Join extends RecursiveTask<Integer> {

    private final static int THRESHOLD = 2;//阀值
    private int start;
    private int end;

    public Fork_Join(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end-start)<=THRESHOLD;
        if(canCompute){
            System.out.println("can compute..."+start+" "+end);
            for(int i = start;i<=end;i++)
                sum += i;
        }else{
            System.out.println("continue to fork..."+start+" "+end);
            int middle = (start+end)/2;
            Fork_Join leftTask = new Fork_Join(start,middle);
            Fork_Join rightTask = new Fork_Join(middle+1,end);
            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult+rightResult;
        }
        return sum;
    }
}
