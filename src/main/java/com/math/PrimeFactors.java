package com.math;

public class PrimeFactors {
    public static void main(String[] args) {
        int n = 7;
        printPrimeFactors(n);
    }

    private static void printPrimeFactors(int n) {
        if(n < 2) return;

        while (n%2 ==0) {
            System.out.print(2+ "\t");
            n/=2;
        }

        for(int i=3;i<=java.lang.Math.sqrt(n);i+=2) {
            while (n%i == 0) {
                System.out.print(i+"\t");
                n/=i;
            }
        }
        if(n>2)
            System.out.print(n);

    }
}
