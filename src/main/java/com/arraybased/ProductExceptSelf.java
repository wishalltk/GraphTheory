package com.arraybased;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] a = {5,0,3};
       // nPass(a);
        twoPass(a);

    }


    static void twoPass(int[] a) {
        int[] p = new int[a.length];
        int product = a[0];
        p[0] = 1;
        for(int i=1;i<a.length;i++) {
            p[i] = product*a[i-1];
            product = p[i];
        }
        System.out.println(Arrays.toString(p));
    }

    static void nPass(int[] a) {
        int[] p = new int[a.length];
        p[0]=1;
        for(int i=1;i<a.length;i++) {
            p[i] = p[i-1]*a[i-1];
        }
        System.out.println(Arrays.toString(p));
        int[] q = new int[a.length];
        q[a.length-1] = 1;
        for(int i=a.length-2;i>=0;i--) {
            q[i] = q[i+1]*a[i+1];
        }
        System.out.println(Arrays.toString(q));
        int[] f = new int[a.length];
        for(int i=0;i<a.length;i++) {
            f[i] = p[i]*q[i];
        }
        System.out.println(Arrays.toString(f));
    }
}
