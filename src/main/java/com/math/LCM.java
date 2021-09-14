package com.math;

public class LCM {

    public static void main(String[] args) {
        int a = 15;
        int b = 25;
        int lcm = lcm(a, b);
        System.out.println("LCM("+a+", "+b+") = "+lcm);
    }

    // product divided by the GCD of two numbers
    static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }

    static int gcd(int a, int b) {
        if(a == b) return a;
        if(a == 0) return b;
        if(b == 0) return a;
        if(a>b) return gcd(a-b, b); else return gcd(a, b-a);
    }
}
