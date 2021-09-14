package com.threads;

import lombok.SneakyThrows;

public class ATM {

    private static volatile int balance = 100;

    public static void main(String[] args) {
        ATM atm = new ATM();
        /*Thread withdraw = new Thread( () -> atm.withdraw(150) );
        Thread deposit = new Thread( () -> atm.deposit(50) );
        withdraw.start();
        deposit.start();*/
        new Thread(atm::printEven).start();
        new Thread(atm::printOdd).start();


    }

    @SneakyThrows
    synchronized void withdraw(int amount) {
        if(amount>balance){
            System.out.println("insufficient balance .. waiting for deposit");
            wait();
        }
        balance = balance - amount;
        System.out.println("withdraw successful: new balance = "+balance);
    }

    synchronized void deposit(int amount) {
        balance = balance+amount;
        System.out.println("deposited "+amount+" rupees, notifying withdrawers");
        notify();
        System.out.println("Notified");
    }

    @SneakyThrows
    synchronized void printEven() {
     //   synchronized (this) {
            for(int i=0;i<100;i++) {
                if(i%2 == 0){
                    System.out.println(i);
                    notify();
                } else {
                    wait();
                }
            }
    //    }

    }

    @SneakyThrows
    synchronized void printOdd() {
       // synchronized (this) {
            for(int i=1;i<100;i++) {
                if(i%2 == 1) {
                    System.out.println(i);
                    notify();
                } else {
                    wait();
                }
            }
       // }

    }
}
