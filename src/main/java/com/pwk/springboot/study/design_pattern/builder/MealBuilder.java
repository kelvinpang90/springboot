package com.pwk.springboot.study.design_pattern.builder;

public class MealBuilder {
    public Meal prepare(String burger,String coldDrink){
        Meal meal = new Meal();
        if(burger.equalsIgnoreCase("vegBurger"))
            meal.addItem(new VegBurger());
        if(burger.equalsIgnoreCase("chickenBurger"))
            meal.addItem(new ChickenBurger());
        if(coldDrink.equalsIgnoreCase("coke"))
            meal.addItem(new Coke());
        if(coldDrink.equalsIgnoreCase("pepsi"))
            meal.addItem(new Pepsi());
        return meal;
    }
}
