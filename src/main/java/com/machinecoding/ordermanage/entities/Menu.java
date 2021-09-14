package com.machinecoding.ordermanage.entities;

import java.util.Optional;
import java.util.Set;

public class Menu {
    public Menu(Set<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public Set<FoodItem> getFoodItems() {
        return foodItems;
    }

    private Set<FoodItem> foodItems;

    public Optional<FoodItem> getItem(String itemName){
       return foodItems.stream().filter( x -> x.getName().equals(itemName)).findFirst();
    }
}
