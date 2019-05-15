package com.pwk.springboot.study.design_pattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getTotalPrice(){
        float price = 0f;
        for(Item item:items){
            price += item.price();
        }
        return price;
    }

    public void showMeal(){
        for(Item item:items){
            System.out.print("name:"+item.name()+" ");
            System.out.print("price:"+item.price()+" ");
            System.out.println("packing:"+item.packing().pack());
        }
    }
}
