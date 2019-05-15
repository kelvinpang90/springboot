package com.pwk.springboot.study.sort;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {
    public static <E extends Comparable<E>>void sort(List<E> list){
        Heap<E> heap = new Heap<>();
        for(E e:list){
            heap.add(e);
        }
        System.out.println(heap);
    }
}

class Heap<E extends Comparable<E>> {

    private List<E> list = new ArrayList<>();

    public Heap(List<E> list) {
        this.list = list;
    }

    public Heap() {}

     /**
      * after add a new element,while it is greater than it's parent, switch their position, until new element is less than or equal its parent
     * @param e e is the element to be added
     */
    public void add(E e){
        list.add(e);
        int newElementIndex = list.size()-1;
        while (newElementIndex>0){
            int parentIndex = (newElementIndex-1)/2;
            if(list.get(newElementIndex).compareTo(list.get(parentIndex))>0){
                E temp = list.get(newElementIndex);
                list.set(newElementIndex,list.get(parentIndex));
                list.set(parentIndex,temp);
            }else{
                break;
            }
            newElementIndex = parentIndex;
        }
    }

    public E removeRoot(){
        if(list.size()<=0) return null;
        E e = list.get(0);
        list.set(0,list.get(list.size()-1));
        list.remove(list.size()-1);

        int currentIndex = 0;
        //whether it has child
        while(currentIndex<list.size()){
            int leftChild = currentIndex*2+1;
            int rightChild = currentIndex*2+2;
            int maxChild = leftChild;
            if(leftChild>=list.size()) break;
            if(rightChild<list.size()) {
                if (list.get(rightChild).compareTo(list.get(leftChild)) > 0)
                    maxChild = rightChild;
            }

            if(list.get(currentIndex).compareTo(list.get(maxChild))<0){
                E temp = list.get(currentIndex);
                list.set(currentIndex,list.get(maxChild));
                list.set(maxChild,temp);
                currentIndex = maxChild;
            }else
                break;
        }
        return e;
    }

    public int size(){
        return list.size();
    }

    @Override
    public String toString() {
        return "Heap{" +
                "list=" + list +
                '}';
    }
}