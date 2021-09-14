package com.recursion;

public class CountPartition {

    public static void main(String[] args) {
        CountPartition cp = new CountPartition();
        int ways = cp.countWays(7, 4);
        System.out.println(ways);
    }

    int countWays(int n, int m) {
        if(m == 0 || n < 0) return 0;
        if(n == 0) return 1 ;

        return countWays(n, m-1)+countWays(n-m, m);
    }
}

