package com.aditya.verma;

public class LCPalSubSequence {
    public static void main(String[] args) {
        String input = "agbcba";
        System.out.println(lcpsseq(input));
    }

    private static int lcpsseq(String input) {
        String two = new StringBuilder(input).reverse().toString();
        int l = two.length();
        return lcs(input, two, l, l);
    }

    private static int lcs(String one, String two, int m, int n) {
        if(m == 0 || n == 0)
            return 0;

        if(one.charAt(m-1) == two.charAt(n-1))
            return 1 + lcs(one, two, m-1, n-1);

        return Math.max(lcs(one, two, m-1, n), lcs(one, two, m, n-1));
    }
}
