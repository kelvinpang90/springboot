package com.pwk.springboot.study.algorithm;

public class Algorithm {

    public static void main(String[] args){
        int[] a = {-1,22,3,-2,5,1,-5};
        System.out.println(maxSubSum1(a));

        System.out.println(50+(50>>1));
    }

    /*
    运算时间
    s+=i*i*i(2次乘法,一次相加,一次赋值)，共4个时间单位，共执行N次，则4N个时间单位
    则该方法运算时间为O(n)
     */
    private int sum(int n){
        int s = 0;
        for(int i=0;i<n;i++)
            s+=i*i*i;
        return s;
    }

    /*
    最大子序列求和问题
    假设有整数序列a(可能有负数)，求在序列中，能够得到和最大的子序列
     */

    private static int maxSubSum1(int[] a){
        int maxSum=0,thisSum=0;
        for(int i = 0;i<a.length;i++){
            thisSum += a[i];

            if(thisSum>maxSum)
                maxSum = thisSum;
            else if(thisSum<0)
                thisSum = 0;
        }
        return maxSum;
    }
}

