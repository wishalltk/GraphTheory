package com.machinecoding.ordermanage.service;

import com.machinecoding.ordermanage.entities.Restaurant;

public interface RestaurantServices{
    void onboard(Restaurant restaurant) throws Exception;
    void createOrUpdateFoodItem(String rName, String itemName, int price) throws Exception;
    void updateOrderStatus(String rName, String orderId, String orderStatus) throws Exception;
}
