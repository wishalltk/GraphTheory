package com.threads;

import lombok.SneakyThrows;

public class NumberPrinting {

   // ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t = new Thread(new SyncedNumberPrinter(100));
        t.start();
        //subOptimalWay();
    }

    static void subOptimalWay() {
        int limit = 100;
        Thread even = new Thread(new EvenNumberPrinter(limit));
        Thread odd = new Thread(new OddNumberPrinter(limit));
         odd.start();
         even.start();
        //new NumberPrinting().test();
    }


    synchronized static void print(int n) {
        System.out.println(n);
    }
}

class SyncedNumberPrinter implements Runnable {

    private final int limit;

    private static transient int counter = 0;

    SyncedNumberPrinter(int limit) {
        this.limit = limit;
    }

    @SneakyThrows
    @Override
    public void run() {
        printEven();
        printOdd();
    }

   synchronized void printEven() throws InterruptedException {
        System.out.println("even started");
    }

    @SneakyThrows
   synchronized void printOdd() {
        System.out.println("odd started");

    }
}

class EvenNumberPrinter implements Runnable {
    private final int limit;

    EvenNumberPrinter(int limit) {
        this.limit = limit;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i <= limit; i++) {
            if (i % 2 == 0)
                NumberPrinting.print(i);
            Thread.sleep(100);
        }
    }
}

class OddNumberPrinter implements Runnable {

    private final int limit;

    OddNumberPrinter(int limit) {
        this.limit = limit;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            if (i % 2 != 0)
                NumberPrinting.print(i);
            Thread.sleep(100);
        }
    }
}
