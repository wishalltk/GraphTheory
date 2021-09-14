package com.machinecoding.ordermanage.entities;

public class FoodItem {
    private final String name;

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public FoodItem(String name, int price) throws IllegalAccessException {
        if(price <= 0)
            throw new IllegalAccessException("price should be greater than zero ");
        this.name = name;
        this.price = price;
    }
}
