package com.threads;

import lombok.SneakyThrows;

import java.util.Scanner;

public class TestThreadVariable {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t = new Thread(new Printer());
        t.start();
        //printer.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("hit enter to stop thread");
        scanner.nextLine();
        printer.shutDown();
    }
}

class Printer implements Runnable {

    volatile boolean running = true;

    @SneakyThrows
    @Override
    public void run() {
        int counter = 1;
        while (running) {
            System.out.println("I am running .. "+counter++);
            Thread.sleep(500);
        }
    }

    public void shutDown() {
        System.out.println("shutting down");
        running = false;
    }
}
