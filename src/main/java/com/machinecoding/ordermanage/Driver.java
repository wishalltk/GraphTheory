package com.machinecoding.ordermanage;

import com.machinecoding.ordermanage.dao.InMemoryDataStore;
import com.machinecoding.ordermanage.entities.*;
import com.machinecoding.ordermanage.service.OrderService;
import com.machinecoding.ordermanage.service.OrderServiceImpl;
import com.machinecoding.ordermanage.service.RestaurantServices;
import com.machinecoding.ordermanage.service.RestaurantServicesImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Driver {
    public static void main(String[] args) throws Exception {
        InMemoryDataStore dataStore = InMemoryDataStore.getInstance();
        RestaurantServices restaurantServices = new RestaurantServicesImpl(dataStore);
        OrderService orderService = new OrderServiceImpl(dataStore);
        Restaurant r1 = new Restaurant("R1", 4.5d, 1);
        Set<FoodItem> foodItemSet1 = new HashSet<>();
        foodItemSet1.add(new FoodItem("Biryani", 250));
        foodItemSet1.add(new FoodItem("Paneer", 150));
        Menu menu1 = new Menu(foodItemSet1);
        r1.setMenu(menu1);

        Restaurant r2 = new Restaurant("R2", 4.4d, 2);
        Set<FoodItem> foodItemSet2 = new HashSet<>();
        foodItemSet2.add(new FoodItem("Biryani", 250));
        foodItemSet2.add(new FoodItem("Paneer", 150));
        Menu menu2 = new Menu(foodItemSet2);
        r2.setMenu(menu2);

        restaurantServices.onboard(r1);
        restaurantServices.onboard(r2);

        OrderRequest or1 = new OrderRequest("OD1", "vishal", SelectionStrategy.HIGH_RATING);
        OrderItem Biryani = new OrderItem("Biryani", 1);
        OrderItem Paneer = new OrderItem("Paneer", 1);
        List<OrderItem> itemList = new ArrayList<>();
        itemList.add(Biryani);
        itemList.add(Paneer);
        or1.setItems(itemList);

        OrderRequest or2 = new OrderRequest("OD2", "vishaltk", SelectionStrategy.HIGH_RATING);
        OrderItem Bir = new OrderItem("Biryani", 1);
        OrderItem Pan = new OrderItem("Paneer", 1);
        List<OrderItem> itemList1 = new ArrayList<>();
        itemList1.add(Bir);
        itemList1.add(Pan);
        or2.setItems(itemList1);

        String resp1 = orderService.placeOrder(or1);
        String resp2 = orderService.placeOrder(or2);
        String resp3 = orderService.placeOrder(or1);
        String resp4 = orderService.placeOrder(or1);

        System.out.println(resp1);
        System.out.println(resp2);
        System.out.println(resp3);
        System.out.println(resp4);
        restaurantServices.updateOrderStatus("R3", "OD1", "COMPLETED");
        String resp5 = orderService.placeOrder(or1);
        System.out.println(resp5);


    }
}
