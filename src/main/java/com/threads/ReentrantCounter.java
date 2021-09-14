package com.threads;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantCounter {

    int count = 0;

    ReentrantLock lock = new ReentrantLock();

    @SneakyThrows
    public static void main(String[] args) {

        ReentrantCounter c = new ReentrantCounter();

        Thread one = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                c.increment();
            }
        });
        Thread two = new Thread(() -> {
            for (int j = 0; j < 100000; j++)
                c.increment();
        });
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println(c.count);

    }

    void increment() {
        lock.lock();
        count++;
        lock.unlock();
    }
}
