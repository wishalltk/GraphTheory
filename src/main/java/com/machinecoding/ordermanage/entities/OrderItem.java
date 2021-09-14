package com.machinecoding.ordermanage.entities;

public class OrderItem {
    String itemName;
    int quantity;

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }
}
