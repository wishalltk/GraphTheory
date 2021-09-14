package com.machinecoding.ordermanage.entities;

public class AvailableRestaurantData {
    public String getrName() {
        return rName;
    }

    private String rName;
    private int totalCost;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private double rating;

    public AvailableRestaurantData(String rName,  double rating) {
        this.rName = rName;
        this.rating = rating;
    }
}
