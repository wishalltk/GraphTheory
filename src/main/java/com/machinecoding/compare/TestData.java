package com.machinecoding.compare;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    static List<FoodItem> getTestData() {
        FoodItem f1 = new FoodItem("biryani", 250, 4.5);
        FoodItem f7 = new FoodItem("biryani", 200, 4.3);
        FoodItem f2 = new FoodItem("paneer", 150, 4.4);
        FoodItem f3 = new FoodItem("rice", 100, 3.0);
        FoodItem f4 = new FoodItem("roll", 75, 2.2);
        FoodItem f5 = new FoodItem("dosa", 60, 4.8);
        FoodItem f6 = new FoodItem("idli", 60, 4.7);
        FoodItem f8 = new FoodItem("appam", 60, 4.7);

        List<FoodItem> foodItemList = new ArrayList<>();
        foodItemList.add(f1);
        foodItemList.add(f2);
        foodItemList.add(f3);
        foodItemList.add(f4);
        foodItemList.add(f5);
        foodItemList.add(f6);
        foodItemList.add(f7);
        foodItemList.add(f8);

        return foodItemList;
    }
}
