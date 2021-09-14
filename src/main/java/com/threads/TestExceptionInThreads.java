package com.threads;

import lombok.SneakyThrows;

public class TestExceptionInThreads {
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("starting some job");
        trigger();
        System.out.println("starting another job");
        Thread.sleep(500);
        for(int i=0;i<10;i++)
            System.out.println(1);
    }

    static void trigger() {
        Thread t1 = new Thread( () -> {
            for(int i=0;i<10;i++) {
                System.out.println(i);
                // try {
                //Thread.sleep(1000);
                if(i == 8)
                    throw new RuntimeException("i == 8");
                //} catch (InterruptedException e) {
                //   e.printStackTrace();
                //}
            }
        } );

        System.out.println("starting thread");
        t1.setDaemon(false);
        t1.start();
        System.out.println("completed thread");
    }
}
