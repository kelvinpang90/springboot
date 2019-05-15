package com.pwk.springboot.study;

import java.util.Iterator;

public class Inner_Class {
//    private static int i = 10;
    private int j = 20;

    private final static int SIZE = 10;
    private Integer[] array = new Integer[10];

    public Inner_Class() {
        for(int i = 0;i<SIZE;i++){
            array[i] = i;
        }
    }

    public void printEven(){
        IntIterator it = new IntIterator();
        while(it.hasNext()){
            System.out.println(it.next()+" ");
        }
    }

//    interface DataIterator extends Iterator{}

    public static String add(){
        return "added";
    }

    public String delete(){
        return "deleted";
    }

    private static class InnerStatic{
        private int i = 20;
        private void test(int i){
            //there are 3 i, 1st is method parameter, 2nd is inner class variable, 3rd is outer class variable
            System.out.println(i);
            System.out.println(this.i);
//            System.out.println(Inner_Class.i);
            System.out.println(add());
        }
    }

    private class Inner {
        private void test() {
//            System.out.println(i);
            System.out.println(j);
            System.out.println(delete());
        }
    }
    private class IntIterator implements Iterator{

        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return nextIndex <= SIZE-1;
        }

        @Override
        public Integer next() {
            Integer record = array[nextIndex];
            nextIndex+=2;
            return record;
        }
    }


    public static void main(String[] args){
        //initial a static inner class
        Inner_Class.InnerStatic example = new Inner_Class.InnerStatic();
        example.test(30);

        //initial a non-static inner class
        Inner_Class.Inner example2 = new Inner_Class().new Inner();
        example2.test();

        Inner_Class inner_class = new Inner_Class();
        inner_class.printEven();
    }
}
