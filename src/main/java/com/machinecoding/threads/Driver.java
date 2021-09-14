package com.machinecoding.threads;

import java.util.LinkedList;
import java.util.Queue;

public class Driver implements Runnable{

    private final OrderGateWay orderGateWay;
    private final String clientName;

    Queue<RequirementData> testData;

    public Driver(OrderGateWay orderGateWay, String clientName) {
        this.orderGateWay = orderGateWay;
        testData = new LinkedList<>();
        this.clientName = clientName;
    }

    Driver setTestData(RequirementData data) {
        testData.add(data);
        return this;
    }

    @Override
    public void run() {
        while (!testData.isEmpty()){
            RequirementData data = testData.poll();
            //System.out.println("Placing order for client "+clientName+" item="+data.item+" qty="+data.qty);
            OrderResponse response = orderGateWay.placeOrder(data.item, data.qty);
            if(response.getHttpCode()==200)
                orderGateWay.updateStock(data.item, data.qty);
            //System.out.println(response.getMessage());
        }
        System.out.println("order placement complete for all requirements client "+clientName);
    }
}
