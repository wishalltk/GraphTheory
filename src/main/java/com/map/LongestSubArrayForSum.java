package com.map;

import java.util.*;

public class LongestSubArrayForSum {
    public static void main(String[] args) {
        int[] a = {3,1,2,4};
        int k = 3;
        int length = getLength(a, k);
        int length1 = getAnswer(a, k);
        System.out.println(length + ", " + length1);
    }

    private static int getAnswer(int[] a, int k) {
        int[] dp = new int[a.length];
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == k) {
                    max = Math.max(max, (j - i) + 1);
                    System.out.println(i + "~" + j);
                }
            }
        }
        return max;
    }

    private static int getLength(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        int n = arr.length;
        // traverse the given array
        for (int i = 0; i < n; i++) {

            // accumulate sum
            sum += arr[i];

            // when sub-array starts from index '0'
            if (sum == k)
                maxLen = i + 1;

            // make an entry for 'sum' if it is
            // not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-k' is present in 'map'
            // or not
            if (map.containsKey(sum - k)) {

                // update maxLength
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }

        return maxLen;
    }
}
