package com.machinecoding.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatastore {

    public Map<String, Integer> getItemStock() {
        return itemStock;
    }

    public static Map<String, Integer> getOrderCounter() {
        return orderCounter;
    }

    private static Map<String, Integer> orderCounter;

    private static Map<String, Integer> itemStock;
    private static InMemoryDatastore instance;

    private InMemoryDatastore() {
        if(null == itemStock)
            itemStock = new HashMap<>();
        if(null == orderCounter)
            orderCounter = new ConcurrentHashMap<>();
    }

    public void updateOrderCounter(String itemName, int count) {
        orderCounter.merge(itemName, count, Integer::sum);
    }

    public static InMemoryDatastore getInstance() {
        if(null == instance)
            instance = new InMemoryDatastore();
        return instance;
    }
}
