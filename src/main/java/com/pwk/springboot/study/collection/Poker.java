package com.pwk.springboot.study.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker{
    public final static int SIZE = 52;

    private List<String> list;
    public Poker() {
        String[] suit = new String[]{"spades", "hearts", "diamonds", "clubs"};
        String[] rank = new String[]{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
        list = new ArrayList<>();
        for(String suit1: suit){
            for(String rank1: rank){
                list.add(suit1+" "+rank1);
            }
        }
    }

    public int size(){
        return list.size();
    }

    public void shuffle(){
        Collections.shuffle(list);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    //派牌
    public List<String> dealHand(int n){
        int size = list.size();
        List<String> handView = list.subList(size-n,size);
        List<String> hand = new ArrayList<>(handView);
        handView.clear();
        return hand;
    }
}
