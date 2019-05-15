package com.pwk.springboot.study.collection;

public class Test {
    public static void main(String[] args){
        MyList<String> list = new MyArrayList<>(new String[]{"a","b","c","d"});
        ((MyArrayList<String>) list).trimToSize();
        System.out.println(list);
        list.add("e");
        System.out.println(list);
        list.remove("a");
        System.out.println(list.get(0));


        Tree<Integer> tree = new BST<>(new Integer[]{1,3,5,7,9,11});
        tree.inorder();
        System.out.println();
        tree.delete(11);
        tree.inorder();
        System.out.println();
    }
}
