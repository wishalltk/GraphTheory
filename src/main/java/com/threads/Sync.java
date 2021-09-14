package com.threads;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

public class Sync {
    private int count = 0;

    private synchronized void update() {
        count++;
    }

    @SneakyThrows
    public static void main(String[] args) {
        Sync s = new Sync();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
                s.update();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
                s.update();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count is "+ s.count);
    }
}
