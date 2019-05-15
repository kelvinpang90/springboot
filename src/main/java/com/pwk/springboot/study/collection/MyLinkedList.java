package com.pwk.springboot.study.collection;

import javax.validation.constraints.NotNull;
import java.util.Iterator;

public class MyLinkedList<T> extends MyAbstractList<T> {
    private Node<T> first;
    private Node<T> last;

    private int size = 0;

    public void addFirst(T t){
        Node<T> newNode = new Node<>(t);
        if(size == 0){
            first = last = newNode;
        }else{
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void addLast(T t){
        Node<T> newNode = new Node<>(t);
        if(size == 0){
            first = last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public T getFirst(){
        return first.element;
    }

    public T getLast(){
        return last.element;
    }

    public T removeFirst(){
        if(size == 0) return null;
        Node<T> t = first;
        if(size==1){
            last = first = null;
        }else{
            first = first.next;
        }
        size--;
        return t.element;
    }

    public T removeLast(){
        if(size == 0) return null;
        Node<T> t = last;
        if(size == 1){
            first = last = null;
        }else{
            Node<T> current = first;
            for(int i = 0;i<size-2;i++){
                current = current.next;
            }
            current.next = null;
            last = current;
        }
        size--;
        return t.element;
    }

    @Override
    public void add(int index, T t) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("index "+index+" out of bounds");
        }
        Node<T> newNode = new Node<>(t);
        if(size == 0){
            first = last = newNode;
        }else{
            Node<T> current = first;
            for(int i = 1;i<index-1;i++) current = current.next;
            Node<T> oldNext = current.next;
            current.next = newNode;
            newNode.next = oldNext;
        }
        size++;
    }

    @Override
    public void clear() {
        size = 0;
        first = last = null;
    }

    @Override
    public boolean contains(T t) {
        if(t != null){
            for(Node<T> current = first;current!=null;current = current.next){
                if(current.element.equals(t))
                    return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("index "+index+" out of bounds");
        }
        Node<T> current = first ;
        if(index == 0) return first.element;
        else{
            for(int i = 0;i<index-1;i++){
                current = current.next;
            }
            return current.element;
        }
    }

    @Override
    public int indexOf(T t) {
        Node<T> current = first;
        if(t == current) return 0;
        for(int i = 1;i<size-1;i++){
            current = first.next;
            if(current.element.equals(t))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T t) {

        return -1;
    }

    @Override
    public T remove(int index) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("index "+index+" out of bounds");
        }
        if(index == 0)
            removeFirst();
        else if(index == size-1)
            removeLast();
        else{
            Node<T> prev = first;
            for(int i = 1;i<index;i++){
                prev = prev.next;
            }
            Node<T> current = prev.next;
            prev.next = current.next;
            size--;
            return current.element;
        }
        return null;
    }

    @Override
    public T set(int index, T t) {
        if(index == 0) addFirst(t);
        else if(index == size-1) addLast(t);
        else{
            Node<T> current = first;
            Node<T> newNode = new Node<>(t);
            for(int i = 1;i<index;i++){
                current = current.next;
            }
            Node<T> next = current.next;
            current.next = newNode;
            newNode.next = next;
        }
        return t;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return null;
    }



    private class Node<T>{
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}
