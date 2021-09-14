package com.machinecoding.ordermanage.entities;

import java.util.*;
import java.util.stream.Collectors;

public class Restaurant {
    private final String name;

    public double getRating() {
        return rating;
    }

    private final double rating;

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    private Menu menu;

    private final int maxOrders;

    private final List<OrderRequest> orderQueue;

    public Restaurant(String name, double rating, int maxOrders) {
        this.name = name;
        this.rating = rating;
        this.maxOrders = maxOrders;
        this.orderQueue = new ArrayList<>();
    }
    public boolean isCapacityExhausted() {
        return orderQueue.size() == maxOrders;
    }

    public List<OrderRequest> getOrderQueue() {
        return orderQueue;
    }

    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }

    public List<FoodItem> fetchItemsData (List<String> items) {
        List<FoodItem> availableItems = new ArrayList<>();
        for(String item: items) {
            List<FoodItem> collect = menu.getFoodItems().stream().filter(x -> x.getName().equals(item)).collect(Collectors.toList());
            availableItems.addAll(collect);
        }
        if(availableItems.size() == items.size())
            return availableItems;
        else
            return Collections.emptyList();

    }



}
