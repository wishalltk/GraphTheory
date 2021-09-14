package com.machinecoding.ordermanage.service;

import com.machinecoding.ordermanage.dao.InMemoryDataStore;
import com.machinecoding.ordermanage.entities.FoodItem;
import com.machinecoding.ordermanage.entities.OrderRequest;
import com.machinecoding.ordermanage.entities.OrderStatus;
import com.machinecoding.ordermanage.entities.Restaurant;

import java.util.Optional;

public class RestaurantServicesImpl implements RestaurantServices {

    private final InMemoryDataStore dataStore;

    public RestaurantServicesImpl(InMemoryDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void onboard(Restaurant restaurant) throws Exception {
        Restaurant restaurantByName = dataStore.getRestaurantByName(restaurant.getName());
        if(null == restaurantByName)
            dataStore.addRestaurant(restaurant);
        else
            throw new Exception("Restaurant "+restaurant.getName()+" already exists");

    }

    @Override
    public void createOrUpdateFoodItem(String rName, String itemName, int price) throws Exception {
        Restaurant restaurantNullable = dataStore.getRestaurantByName(rName);
        if(null == restaurantNullable)
            throw new Exception("Restaurant "+rName+" does not exist");
        Optional<FoodItem> itemOptional = restaurantNullable.getMenu().getItem(itemName);
        if(itemOptional.isPresent())
            itemOptional.get().setPrice(price);
        else
            restaurantNullable.getMenu().getFoodItems().add(new FoodItem(itemName, price));
    }

    @Override
    public void updateOrderStatus(String rName, String orderId, String orderStatus) throws Exception {
        Restaurant restaurant = dataStore.getRestaurantByName(rName);
        if(null == restaurant)
            throw new Exception("restaurant not found");
        Optional<OrderRequest> orderRequestOptional = restaurant.getOrderQueue().stream()
                .filter(x -> x.getOrderId().equals(orderId))
                .findFirst();
        if(!orderRequestOptional.isPresent())
            throw new Exception("Order Id not found "+orderId);
        OrderRequest orderRequest = orderRequestOptional.get();
        OrderStatus nextStatus = OrderStatus.valueOf(orderStatus);
        if(nextStatus.equals(OrderStatus.CANCELLED))
            throw new Exception("ACCEPTED Order "+orderId+" can not be cancelled");
        orderRequest.setOrderStatus(nextStatus);
        restaurant.getOrderQueue().remove(orderRequest);
    }
}
