package com.aditya.verma;

public class SumOfArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int sum = sum(a);
        System.out.println("sum is " + sum);
    }

    private static Integer sum(int[] a) {
        if (null == a)
            return null;
        else if (a.length == 0)
            return 0;
        else if (a.length == 1)
            return a[0];
        else
            return sumFwdDir(a, 0);
    }

    private static int sumRevDir(int[] a, int length) {
        if (length == 1)
            return a[0];
        return a[length - 1] + sumRevDir(a, length - 1);
    }

    private static int sumFwdDir(int[] a, int idx) {
        if (idx == a.length - 1)
            return a[idx];
        return a[idx]+sumFwdDir(a, idx+1);
    }
}
