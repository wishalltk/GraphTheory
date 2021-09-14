package com.arraybased;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = a.clone();
        //         6 7 1 2 3 4 5
        String name = "vishal";

        long ans = 9L;
        System.out.println((int) Math.pow(ans, 2));;
        System.out.println(name.substring(1, 2));
        int k = 2;
        System.out.println(Arrays.toString(a));
        int[] na = rotateSmart(a, k);
        int[] ns = rotateNonSmart(b, k);
       System.out.println(Arrays.toString(na));
        System.out.println(Arrays.toString(ns));
    //    System.out.println(Arrays.toString(rotateLeft(b, k)));
    }
// 0,1,2,3,4,5 = n-> 6 n-k=4
    static int[] rotateNonSmart(int[] a, int k) {
        int n = a.length;
        int[] b = new int[n];
        int counter = 0;
        for(int i=n-k;i<n;i++)
            b[counter++]=a[i];
        for(int j=0;j<n-k;j++)
            b[counter++]=a[j];
        return b;
    }

    static int[] rotateSmart(int[] a, int k) {
        int n = a.length;
        if(k>n) {
            k=k%n;
        }
        if(k == 0) return a;
        // reverse the first n-k elements
        reverse(a, 0, n-k-1);
        reverse(a, a.length-k, a.length-1);
        reverse(a, 0, a.length-1);
        // reverse the last k elements
        // reverse the whole array
        return a;

    }

    static void reverse(int[] a, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }

    static int[] rotate(int[] a, int k) {
        if(k > a.length)
            k = k % a.length;
        if(k  == 0)
            return a;
        int[] na = new int[a.length];
        System.arraycopy(a, 0, na, a.length-k,k);
        System.arraycopy(a, k, na, 0, a.length-k);
        return na;
    }

    private static int[] rotateRight(int[] a, int k) {
        int[] na = new int[a.length];
        while (k-- > 0) {
            int start = a[a.length-1];
            //System.arraycopy(a, 1, a, 0, a.length-2);
            for(int i=a.length-1;i>0;i--)
            a[i]=a[i-1];
            //System.arraycopy(a, 0, a, 1, a.length - 1);
            a[0]=start;
        }

        return a;
    }

    protected static int[] rotateLeft(int[] a, int k) {
        while (k-- >0) {
            int start = a[0];
            //for(int i=0;i<a.length-1;i++) {
            //    a[i]=a[i+1];
            System.arraycopy(a, 1,a,0,a.length-1);
            //}
            a[a.length-1]=start;
        }
        return a;
    }
}
