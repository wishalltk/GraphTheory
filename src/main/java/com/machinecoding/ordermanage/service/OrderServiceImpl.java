package com.machinecoding.ordermanage.service;

import com.machinecoding.ordermanage.dao.InMemoryDataStore;
import com.machinecoding.ordermanage.entities.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private final InMemoryDataStore dataStore;

    public OrderServiceImpl(InMemoryDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public String placeOrder(OrderRequest orderRequest) {
        List<AvailableRestaurantData> availableRestaurantDataList = new ArrayList<>();
        List<OrderItem> orderItems = orderRequest.getItems();
        List<String> items = orderItems.stream().map(OrderItem::getItemName).collect(Collectors.toList());
        Map<String, Restaurant> restaurants = dataStore.getRestaurants();
        for(Entry<String, Restaurant> entry: restaurants.entrySet()){
            Restaurant restaurant = entry.getValue();
            if(!restaurant.isCapacityExhausted()) {
                List<FoodItem> availableFoodItems = restaurant.fetchItemsData(items);
                if(!availableFoodItems.isEmpty()) {
                   availableRestaurantDataList.add(
                           new AvailableRestaurantData(entry.getKey(),entry.getValue().getRating())
                   );
                }
            }
        }
        if(availableRestaurantDataList.isEmpty())
            return "No restaurants available to fulfill this order";
        availableRestaurantDataList.sort(new SortByRating());
        AvailableRestaurantData availableRestaurantData = availableRestaurantDataList.get(0);
        Restaurant restaurantByName = dataStore.getRestaurantByName(availableRestaurantData.getrName());
        orderRequest.setOrderStatus(OrderStatus.ACCEPTED);
        restaurantByName.getOrderQueue().add(orderRequest);
        return "Order assigned to "+availableRestaurantData.getrName();
    }
}

class SortByRating implements Comparator<AvailableRestaurantData> {

    @Override
    public int compare(AvailableRestaurantData o1, AvailableRestaurantData o2) {
        return Double.compare(o2.getRating(), o1.getRating());
    }
}
