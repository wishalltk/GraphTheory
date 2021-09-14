package com.machinecoding.ordermanage.service;

import com.machinecoding.ordermanage.entities.OrderRequest;

public interface OrderService {
    String placeOrder(OrderRequest orderRequest);
}
