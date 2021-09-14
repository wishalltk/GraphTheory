package com.aditya.verma;

public class LCSubString {
    static int[][] memo;
    public static void main(String[] args) {
        String x = "abcdxyz";
        String y = "xyzabcd";
        int m = x.length();
        int n = y.length();
        memo = new int[m+1][n+1];

        int len = lcsTopDown(x,y,m,n);
        System.out.println("lcs="+len);
    }

    private static int lcsTopDown(String x, String y, int m, int n) {
        int maxLength = 0;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(x.charAt(m-i) == y.charAt(n-j)) {
                    memo[i][j] = memo[i-1][j-1]+1;
                    maxLength = Math.max(maxLength, memo[i][j]);
                }
            }
        }
        return maxLength;
    }
}
