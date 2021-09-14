package com.aditya.verma;
import java.util.*;
class PerfSquare {
    int min = Integer.MAX_VALUE;
    int memo[][] = null;

    public static void main(String[] args) {
        int ans = new PerfSquare().numSquares(5);
        System.out.println(ans);
    }
    public int numSquares(int n) {

        List<Integer> list = getAllPerfSquares(n);
        int length = list.size();
        memo = new int[2][n+1];
        //Arrays.fill(Integer.MAX_VALUE, memo[1]);
        Arrays.fill(memo[1], Integer.MAX_VALUE);
        memo[0][0] = 0;
        memo[0][1] = 1;
        memo[1][1] = 1;

        minSquares(list, n);
        System.out.println(Arrays.toString(memo[1]));
        return memo[1][length];

    }

    void minSquares(List<Integer> sqrs, int target) {

        for(int sqr: sqrs) {
            for(int t=1;t<=target;t++) {
                int remain = t-sqr;
                if(remain < 0)
                    continue;
                if(memo[0][remain] != 0) {
                    memo[0][t] += memo[0][remain];
                    memo[1][t] = Math.min(memo[1][t], 1 + memo[1][remain]);
                }
            }
        }

    }

    List<Integer> getAllPerfSquares(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        return list;
    }
}
