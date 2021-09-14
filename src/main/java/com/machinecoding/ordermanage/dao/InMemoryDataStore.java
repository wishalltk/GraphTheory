package com.machinecoding.ordermanage.dao;

import com.machinecoding.ordermanage.entities.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDataStore {


    public Map<String, Restaurant> getRestaurants() {
        return restaurants;
    }

    public Restaurant getRestaurantByName(String name) {
       return restaurants.get(name);
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getName(), restaurant);
    }

    private static Map<String, Restaurant> restaurants;

    private static InMemoryDataStore dataStore;

    private InMemoryDataStore() {
        if(null == restaurants)
            restaurants = new HashMap<>();
    }

    public static InMemoryDataStore getInstance(){
        if(null == dataStore)
            dataStore = new InMemoryDataStore();
        return dataStore;
    }
}
