package com.math;

public class GCF {
    public static void main(String[] args) {
        int a = 101;
        int b = 2;
        int gcd = gcd(a, b);
        System.out.println("GCD of "+a+" and "+b+" is "+gcd);
    }

    private static int gcd(int a, int b) {
        if(a == b) return a;
        if(a == 0) return b;
        if(b == 0) return a;
        return (a>b) ? gcd(a-b, b) : gcd(a, b-a);
    }
}
