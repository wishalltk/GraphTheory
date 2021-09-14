package com.arraybased;

import java.util.Arrays;

public class WaterTrapping {
    public static void main(String[] args) {
        int[] a = {1,2,3,0,3,2,1};
        int total = onePass(a);
        System.out.println(total);
        //nPass(a);
    }

    static int onePass(int[] a){
        int n = a.length;
        if(n < 3) return 0;
        int total = 0;
        int[] w = new int[n];
        int leftMax = a[0];
        int rightMax = a[n-1];
        int leftPtr = 1;
        int rightPtr = n-1;
        while (leftPtr < rightPtr) {
            if(leftMax < a[leftPtr])
                leftMax = a[leftPtr];
            if(rightMax < a[rightPtr])
                rightMax = a[rightPtr];

            w[leftPtr] = Math.max(0, Math.min(leftMax, rightMax) - a[leftPtr]);
            total += w[leftPtr];
            if(leftMax <= rightMax)
                leftPtr++;
            else
                rightPtr--;
        }
        System.out.println(Arrays.toString(w));
        return total;
    }

    static int nPass(int[] a){
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int[] w = new int[a.length];
        int total = 0;
        int leftMax = a[0];
        int rightMax = a[a.length-1];
        left[0] = leftMax;
        right[a.length-1] = rightMax;
        for(int i=1;i<a.length;i++) {
            if(a[i] > leftMax) {
                leftMax = a[i];
            }
            left[i] = leftMax;
        }

        for(int i = a.length-2;i>=0;i--) {
            if(a[i] > rightMax) {
                rightMax = a[i];
            }
            right[i] = rightMax;
        }

        for(int i=1;i<a.length-1;i++) {
            int min = Math.min(left[i], right[i]);
            if(a[i] < min)
                w[i] = min-a[i];
            total += w[i];
        }
        return total;
    }
}
