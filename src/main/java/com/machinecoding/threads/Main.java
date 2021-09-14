package com.machinecoding.threads;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InMemoryDatastore datastore = InMemoryDatastore.getInstance();
        datastore.getItemStock().put("Biryani", 10);
        datastore.getItemStock().put("Paneer", 20);
        datastore.getItemStock().put("Pasta", 30);

        RequirementData d1 = new RequirementData("Biryani", 1);
        RequirementData d2 = new RequirementData("Paneer", 2);
        RequirementData d3 = new RequirementData("Pasta", 3);

        OrderGateWay gateWay = new OrderGateWay(datastore);
        Driver[] drivers = new Driver[10];
        for(int i=1;i<=drivers.length;i++) {
            Driver d = new Driver(gateWay, "Client_"+i);
            d.setTestData(d1).setTestData(d2).setTestData(d3);
            drivers[i-1] = d;
        }
        long start = System.currentTimeMillis();
        Arrays.stream(drivers).forEach(
                x -> {
                    Thread t = new Thread(x);
                    t.start();
                }
        );
        long end = System.currentTimeMillis();
        System.out.println("total runtime "+(end-start)/1000+" seconds");
        Thread.sleep(1000);
        System.out.println("Order Report");
        InMemoryDatastore.getOrderCounter().forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
