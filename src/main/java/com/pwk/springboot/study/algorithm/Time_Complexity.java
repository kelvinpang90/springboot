package com.pwk.springboot.study.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Time_Complexity {
    public static void main(String[] args){
        //O(n²)(13*13)
        int z = 0;
        for(int i = 0;i<13;i++){
            for(int j = 0;j<13;j++)
                z++;
        }
        System.out.println(z);


//        fibonacci(100);
//            gcd1(100,70);
//        gcdByEuclid(32,30);
//        for(int i = 1000;i>2;i--)
//            getPrimeNumber(i);
//        getPrimeByEratosthenes(1000);
//        eightQueen(8);

    }
    //Fibonacci O(n)
    public static void fibonacci(int n){
        int f1 ;
        int f2 = 1;
        int f3 = 1;
        if(n>=2){
            for(int i=0;i<n;i++){
                f1 = f2;
                f2 = f3;
                f3 = f1+f2;
            }
            System.out.format("Fibonacci (n=%d) %d \n",n,f3);
        }
    }

    //Fibonacci by matrix algorithm
    public static void fibonacciByMatrix(int n){

    }

    //GCD1
    public static void gcd1(int n,int m){
        int gcd = 0;
        if(n == m){
            gcd = n;

        }else if(n>m)
            if(n%m == 0)
                gcd = m;
            else{
                for(int i = m/2;m>=1;i--){
                    if(m%i==0&&n%i==0){
                        gcd = i;
                        break;
                    }
                }
            }
        else{
            if(m%n == 0)
                gcd = n;
            else
                for(int i = n/2;n>=1;i--){
                    if(m%i==0&&n%i==0){
                        gcd = i;
                        break;
                    }
                }
        }
        System.out.println("GCD is "+gcd);
    }

    //GCD by Euclid
    public static void gcdByEuclid(int m,int n){
        if(m%n==0)
            System.out.println(n);
        else
            gcd1(n,m%n);
    }

    //prime number
    public static void getPrimeNumber(int n){
        if(n>1){
            int sqr = (int)Math.sqrt(n);
            int count = 0;
            while(sqr>=2){
                if(n%sqr==0)
                    count++;
                sqr--;
            }
            if(count==0)
                System.out.format("number %d is prime number\n",n);
            else
                System.out.format("number %d is not prime number\n",n);
        }
    }

    //sieve prime by Eratosthenes
    public static void getPrimeByEratosthenes(int n){
        List<Boolean> list = new ArrayList<>();
        //assume all numbers are prime
        for(int i = 0;i<=n;i++){
            list.add(true);
        }
        for(int i = 2;i<=n/i;i++){
            if(list.get(i)){
                for(int k = i;k<=n/i;k++){
                    list.set(k*i,false);
                }
            }
        }
        int count = 0;
        for(int i = 2;i<list.size();i++){
            if(list.get(i)){
                count++;
                System.out.format(i+" ");
            }

        }
        System.out.format("\nprime number below %d is %d",n,count);
    }

    //Eight Queen
    public static void eightQueen(int size){
        List<Integer> queens = new ArrayList<>();
        for(int i = 0;i<size;i++)
            queens.add(-1);
        //k indicate that the number of queens placed so far
        int k = 0;
        while(k>=0&&k<size){
            int column = findPosition(queens,k);
            if(column<0){
                queens.set(k,-1);
                k--;
            }else{
                queens.set(k,column);
                k++;
            }
        }
        if(k == -1)
            System.out.println("No solution");
        else{
            System.out.println(queens);
        }
    }

    public static int findPosition(List<Integer> queens,int row){
        int start = queens.get(row)+1;
        for(int column = start;column<queens.size();column++){
            if(isValid(queens,row,column))
                return column;
        }
        return -1;
    }

    //check column,up-left or up-right conflict
    public static boolean isValid(List<Integer> queens,int row,int column){
//        for(int i = row-1;i>0;i--){
//                if(queens.get(i) == column||queens.get(i+1)==column+1||queens.get(i-1)==column-1)
//                    return false;
//        }
        for(int i = 1;i<=row;i++){
            if(queens.get(row-i)==column||queens.get(row-i)==column+i||queens.get(row-i)==column-i){
                return false;
            }
        }
        return true;
    }
}
