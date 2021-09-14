package com.threads;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter {
   static int limit = 100;
   ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {


    }

    static synchronized void process() {
        Thread even = new Thread(() -> {
            for(int i=0;i<limit;i++) {
                if(i%2 == 0) {
                    printer(i);

                }
            }
        });

        Thread odd = new Thread(() -> {
            for(int i=0;i<limit;i++) {
                if(i%2 == 1)
                    printer(i);
            }
        });
        even.start();
        odd.start();
    }

    synchronized static void printer(int n){
        System.out.println(n);
    }
}




