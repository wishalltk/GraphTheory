package com.threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class PubSub {
    static ArrayBlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<>(1000);

    public static void main(String[] args) {
        Random random = new Random();
        Thread producer = new Thread(() -> {
            while (blockingDeque.size() < 1000) {
                blockingDeque.add(random.nextInt(100));
                System.out.println("queue size: " + blockingDeque.size());
            }

        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (blockingDeque.size() > 0) {
                if (random.nextInt(1000) > 0) {
                    try {
                        int taken = blockingDeque.take();
                        System.out.println("taken " + taken + " from queue. Current size: " + blockingDeque.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Processed all messages in the queue");
        });

        producer.start();
        consumer.start();
    }

}
