package com.threads;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // for(int i=0;i<5;i++) {
        executorService.submit(new PoolBoy(2000));
        executorService.submit(new PoolBoy(2));
        // }
        //executorService.shutdown();
        System.out.println("All job submitted");
      //  boolean b = executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println("All jobs completed");
    }
}

class PoolBoy implements Runnable {

    private final long sleepTime;

    PoolBoy(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Boy # " + sleepTime + " is working");
        Thread.sleep(sleepTime);
        System.out.println("Boy # " + sleepTime + " completed task");
    }
}
