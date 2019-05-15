package com.pwk.springboot.study;

import java.util.ArrayList;
import java.util.List;

@Deprecated
@SuppressWarnings(value = "unchecked")
public class Annotation {

    @Annotation_v2
    @SafeVarargs
    static void call(List<String>... lists){
        String str = lists[0].get(0);
        System.out.println(str);
    }
    public static void main(String[] args){
        List<String> stringList = new ArrayList<>();
//        List<String> stringList1 = new ArrayList<>();

        stringList.add("abcd");
//        stringList1.add("bcde");

        call(stringList);
    }


}
