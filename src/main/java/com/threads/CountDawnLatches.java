package com.threads;

import lombok.SneakyThrows;
import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDawnLatches {
    @SneakyThrows
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(2);
        System.out.println("Launching threads");
        service.submit(new Dog("alpha", latch));
        service.submit(new Dog("beta", latch));
        service.submit(new Dog("gamma", latch));
        service.submit(new Dog("theta", latch));
        service.submit(new Dog("kudi", latch));
        service.submit(new Dog("nana", latch));

        System.out.println("Launched threads");
        latch.await();
        System.out.println("current count is "+latch.getCount());
        System.out.println("All threads completed");
       // service.shutdown();

    }
}

class Dog implements Runnable {
    private final String name;
    CountDownLatch latch;

    Dog(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }


    @SneakyThrows
    @Override
    public void run() {
        latch.countDown();
        System.out.println(name + " started ");
        Thread.sleep(2000);
        System.out.println(name + " finished ");
    }
}
