package com.dynamicProgramming;

import java.util.*;

public class A_Fibonacci {
    Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        A_Fibonacci fibonacci = new A_Fibonacci();
        long nthFib = fibonacci.fib(100);
        System.out.println(nthFib);
        // 1 1 2 3 5
    }

    long fib(long n) {
        if (memo.containsKey(n))
            return memo.get(n);
        if (n <= 2)
            return 1;
        long letsCache = fib(n - 1) + fib(n - 2);
        memo.put(n, letsCache);
        return letsCache;
    }

    void printFibonacciSeries(int n) {
        if (n < 1) return;
        if (n == 1) System.out.print(1 + "\t");
        if (n == 2) System.out.print("1 1 \t");
        long fib1 = 1;
        long fib2 = 1;
        if (n > 2) {
            System.out.print("1\t1\t");
            n = n - 2;
            while (n-- > 0) {
                long fib3 = fib1 + fib2;
                System.out.print(fib3 + "\t");
                fib1 = fib2;
                fib2 = fib3;
            }
        }

    }
}
