package com.math;
import java.util.*;
public class FirstNPrimeNumbers {
    static Set<Integer> memo = new HashSet<>();
    static Set<Integer> primeNumbers = new HashSet<>();
    public static void main(String[] args) {
        int n = 100;
        printNPrimes(n);
        System.out.println("\nVerifying");
        boolean anyInvalid = false;
        for(int i : primeNumbers) {
            if(!checkIfPrime(i)) {
                System.out.println("invalid "+i);
                anyInvalid = true;
            }
        }
        if(!anyInvalid)
            System.out.println("all primes were valid");
    }

    static boolean checkIfPrime(int n) {
        if(n < 2 || (n%2 == 0))
            return false;
        for(int i = 3;i<java.lang.Math.sqrt(n);i+=2) {
            if(n%i == 0)
                return false;
        }
        return true;
    }

    private static void printNPrimes(int n) {
        if(n < 1) {
            System.out.println("Invalid input "+n);
            return;
        }
        System.out.print(2+"\t");
        int counter = n-1;
        int start = 3;
        while (counter > 0) {
            if(isPrime(start)) {
                System.out.print(start+"\t");
                counter-=1;
                memo.add(start);
                primeNumbers.add(start);
            }
            start+=2;
        }
    }

    private static boolean isPrime(int n) {
        int root = (int) java.lang.Math.sqrt(n);
        if(memo.contains(root))
            return false;
        int i;
        for(i=3;i<= java.lang.Math.sqrt(n);i+=2) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
