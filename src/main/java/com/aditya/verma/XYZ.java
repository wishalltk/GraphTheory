package com.aditya.verma;

public class XYZ {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }

    private static int sum(int n) {
        int sum=0;
        for(int i=1;i<=n;i++)
            sum+=i;
        return sum;

        //return n==0?0:n+sum(n-1);
    }
}
