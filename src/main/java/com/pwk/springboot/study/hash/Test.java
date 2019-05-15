package com.pwk.springboot.study.hash;

public class Test {
    public static void main(String[] args){
        MySet<String> set = new MyHashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        System.out.println(set.toString());
        set.remove("ccc");
        System.out.println(set.toString());
    }

    private static int hash(int hashCode){
        return supplementalHash(hashCode)&(4-1);
    }

    private static int supplementalHash(int h){
        h ^= (h>>>20)^(h>>>12);

        return h^(h>>>7)^(h>>>4);
    }
}
