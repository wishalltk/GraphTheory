package com.arraybased;

import java.util.Arrays;
import java.util.*;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        Map<Integer, Integer> memo = new HashMap<>();
        int[] a = {4,10,4,3,8,9};
        int length = LongestIncreasingSubsequenceLength(a, a.length);
        System.out.println(length);
    }

    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one

        int[] tailTable = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len - 1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }

        return len;
    }

    private static int nLogNSolution(int[] a) {
        int size = 0;
        int[] aux = new int[a.length];
        Arrays.fill(aux, -1);
        aux[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                aux[i] = a[i];
            } else {
                int index = lowerBound(a[i], a);
                aux[index] = a[i];
            }
        }
        for (int j : aux) {
            if (j != -1)
                size += 1;
        }
        return size;
    }

    private static int lowerBound(int target, int[] a) {
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > target) {
                index = i;
                break;
            }
        }
        return index;
    }
       /* int low = 0;
        int high = a.length-1;

        // 4, 6, 8, 5
        int index = 0;
        while (low<high) {
            int mid = low+(high-low)/2;
            if(mid>=target)
                high=mid-1;
            else
                low=mid;

        }
        return low;*/


    private static int getLongestIncreasingSubSequenceLength(int[] a) {
        int[] dp = new int[a.length];
        Arrays.fill(dp, 1);
        int max = 1;

        int i, j;
        for (i = 1; i < a.length; i++) {
            for (j = 0; j < i; j++) {
                if (a[i] > a[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }
}
