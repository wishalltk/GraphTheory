package com.machinecoding.threads;

import java.util.Map;

public class OrderGateWay {
    private final InMemoryDatastore datastore;

    public OrderGateWay(InMemoryDatastore datastore) {
        this.datastore = datastore;
    }

    public void updateStock(String item, int count){
        Integer currentStock = InMemoryDatastore.getInstance().getItemStock().get(item);
        int updatedStock = currentStock - count;
        InMemoryDatastore.getInstance().getItemStock().put(item, updatedStock);
    }

     OrderResponse placeOrder(String itemName, Integer quantity) {
         OrderResponse response = new OrderResponse();
        Integer itemStock = datastore.getItemStock().get(itemName);
        if (itemStock == null || 0 == itemStock)
            response.setMessage(itemName + " is out of stock").setHttpCode(500);
        else if (itemStock >= quantity) {
            int updatedStock = itemStock - quantity;
            //datastore.getItemStock().put(itemName, updatedStock);
            datastore.updateOrderCounter(itemName, quantity);
            response.setMessage("order placed for item " + itemName + " with quantity " + quantity + " remaining stock is  " + updatedStock).setHttpCode(500);
        } else
            response.setMessage("not enough quantity to serve the request " + quantity + " > " + itemStock).setHttpCode(500);
        return response;
    }
}
