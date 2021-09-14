package com.machinecoding.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareTest {
    public static void main(String[] args) {

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

        System.out.println("Unsorted");
        foodItemList.forEach(x -> {
            System.out.println(x.getName()+" ~ "+x.getPrice()+" ~ "+x.getRating());
        });

        Comparator<FoodItem> nameComparator = Comparator.comparing(FoodItem::getName);
        Comparator<FoodItem> priceComparator = Comparator.comparing(FoodItem::getPrice).thenComparing(nameComparator);

        foodItemList.sort(priceComparator);

        System.out.println("\n\nSorted");
        foodItemList.forEach(x -> {
            System.out.println(x.getName()+" ~ "+x.getPrice()+" ~ "+x.getRating());
        });

    }
}

class SortByName implements Comparator<FoodItem> {

    @Override
    public int compare(FoodItem o1, FoodItem o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SortByPrice implements Comparator<FoodItem>{

    @Override
    public int compare(FoodItem o1, FoodItem o2) {
        return o1.getPrice() - o2.getPrice();
    }
}

class FoodItem {
    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +"\n";
    }

    private final String name;
    private final int price;
    private final Double rating;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public FoodItem(String name, int price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}
