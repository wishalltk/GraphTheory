package com.arraybased;

import java.util.Arrays;

public class HighestInSubArray {
    public static void main(String[] args) {
        int[] a = {1,0,2,0,1};
        solve(a);
    }

    private static void solve(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftMin = a[0];
        int leftMax = a[0];
        int leftMinPos = 0;
        int leftMaxPos = 0;
        Arrays.fill(left, 1);
        for(int i=1;i<n;i++) {

            if(a[i] > leftMax) {
                leftMax = a[i];
                left[i] = i;
            } else {
                if(a[i] > leftMin) {
                    if(i-leftMinPos <= i-leftMaxPos) {
                        left[i] += i-leftMinPos;
                    }
                }
                if(a[i] > leftMax) {
                    leftMax = a[i];
                    leftMaxPos = a[i];
                }
                if(a[i] < leftMin) {
                    leftMin =  a[i];
                    leftMinPos = i;
                }
            }
        }
        System.out.println();
    }
}
