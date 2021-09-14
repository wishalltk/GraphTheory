package com.recursion;

import java.util.*;


public class RecursionMaths {
    public static void main(String[] args) {
        RecursionMaths obj = new RecursionMaths();
        long ans = obj.powerOf(2,3);
        System.out.println(ans);
    }
    static Map<Long, Long> memo = new HashMap<>();
    long sumOfN(long n) {
        if(memo.containsKey(n)) return memo.get(n);
        if(n == 1)
            return 1;
        long sum= n+sumOfN(n-1);
        memo.put(n, sum);
        return sum;
    }

    long powerOf(long base, long power) {
        if(power == 1) return base;
        return base * powerOf(base, power-1);
    }
}
