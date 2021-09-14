package com.machinecoding.compare;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareUsingAnonymous {
    public static void main(String[] args) {
        List<FoodItem> testData = TestData.getTestData();
        System.out.println("Before sorting");
        System.out.println(testData);

        Comparator<FoodItem> priceComp = Comparator.comparingInt(FoodItem::getPrice);

        Comparator<FoodItem> ratingComp = Comparator.comparing(FoodItem::getRating).reversed();

        Comparator<FoodItem> nameComp = Comparator.comparing(FoodItem::getName);



        Comparator<FoodItem> lowPriceHighRatingThenNameSort = new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem o1, FoodItem o2) {
                int priceComp = o1.getPrice() - o2.getPrice();
                if(priceComp == 0) {
                    int ratingComp =  Double.compare(o2.getRating(), o1.getRating());
                    if(ratingComp == 0)
                        return o1.getName().compareTo(o2.getName());
                    else
                        return ratingComp;
                } else
                    return priceComp;
            }
        };

        testData.sort(lowPriceHighRatingThenNameSort);

        System.out.println("After sorting");
        System.out.println(testData);

    }
}
