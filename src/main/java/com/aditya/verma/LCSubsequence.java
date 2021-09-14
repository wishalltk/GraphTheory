package com.aditya.verma;

import java.util.*;
import java.util.Arrays;

public class LCSubsequence {

    static int[][] memo;
    public static void main(String[] args) {
        String x = "vishal";
        String y = "vihsal";
        memo = new int[7][7];

        int len = lcsTopDown(x,y,6,6);
        System.out.println("lcs="+len);
        List<Integer> list =new ArrayList<>();
    }


    static int lcs(String x, String y, int m, int n) {

        if(memo[m][n] != 0) return memo[m][n];

        if(m == 0 || n == 0 )
            return 0;

        if(x.charAt(m-1) == y.charAt(n-1)) {
            int a =  lcs(x,y,m-1,n-1)+1;
            memo[m][n] = a;
            return a;
        }
        else
            return Math.max(
              lcs(x,y,m-1,n), lcs(x,y,m,n-1)
            );
    }

    static int lcsTopDown(String x, String y, int m, int n) {
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(x.charAt(m-i) == y.charAt(n-j))
                    memo[i][j] = memo[i-1][j-1]+1;
                else
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
            }
        }
        return memo[m][n];
    }
}
