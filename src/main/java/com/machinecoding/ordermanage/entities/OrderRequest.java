package com.machinecoding.ordermanage.entities;

import java.util.List;

public class OrderRequest {
    private final String orderId;

    private final String user;
    private List<OrderItem> items;
    private final SelectionStrategy selectionStrategy;
    private OrderStatus orderStatus;

    public OrderRequest(String orderId, String user, SelectionStrategy selectionStrategy) {
        this.orderId = orderId;
        this.user = user;
        this.selectionStrategy = selectionStrategy;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }


    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getUser() {
        return user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public SelectionStrategy getSelectionStrategy() {
        return selectionStrategy;
    }

}
