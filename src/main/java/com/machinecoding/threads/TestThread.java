package com.machinecoding.threads;

import java.util.Arrays;

public class TestThread {
    public static void main(String[] args) {

    }
    void tryRunnable()  {
        Runner[] threads = new Runner[10];
        for(int i=0;i<threads.length;i++) {
            String threadName = "Thread "+(i+1);
            System.out.println("Creating "+threadName);
            Runner r = new Runner();
            r.setName(threadName);
            threads[i] = r;
        }
        Arrays.stream(threads).forEach(Runner::start);
    }

    void tryThread() {
        for(int i=1;i<=5;i++) {
            Thread t = new Thread(new Runner2("Thread "+i));
            t.start();
        }
    }
}

class Runner2 implements Runnable {

    private final String threadName;

    public Runner2(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for(int i=1;i<=5;i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello "+i+" from "+threadName);
        }
    }
}

class Runner extends Thread {
    @Override
    public void run() {
        System.out.println("inside run method of "+this.getName());
        for(int i=0;i<10;i++)  {
            try {
                Thread.sleep(50);
                System.out.println("Hello "+i+" from "+this.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
