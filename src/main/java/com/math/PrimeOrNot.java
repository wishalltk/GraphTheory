package com.math;

public class PrimeOrNot {
    static int counter = 0;
    static int counterSubOpt = 0;
    public static void main(String[] args) {
        int n = 1453111117;
        boolean isPrime = isPrime(n);
        isPrimeNotOptimal(n);
        System.out.println(n +" is Prime ? "+isPrime);
        System.out.println(counter+ " computations in Optimal way");
        System.out.println(counterSubOpt+ " computations in Sub Optimal way");
    }

    private static boolean isPrimeNotOptimal(int n) {
        if(n < 2)
            return false;
        for(int i=3;i<=java.lang.Math.sqrt(n);i++) {
            counterSubOpt++;
            if(n%i == 0)
                return false;
        }
        return true;
    }


    private static boolean isPrime(int n) {
        if(n < 2 || n%2 == 0)
            return false;
        for(int i=3;i<=java.lang.Math.sqrt(n);i+=2) {
            counter++;
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
