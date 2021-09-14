package com.dynamicProgramming;

import java.util.*;

public class E_BestSum {
    public static void main(String[] args) {
        int[] a = {3, 4, 7, 5};
        List<Integer> bestSum = bestSum(a, 7);
        System.out.println(bestSum);
    }

    private static List<Integer> bestSum(int[] a, int target) {
        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < 0) {
            return null;
        }

        List<Integer> shortest = null;

        for (int n : a) {
            if (n == 0) continue;
            int remain = target - n;
            List<Integer> temp = bestSum(a, remain);
            if (temp == null) {
                continue;
            }
            temp.add(n);
            if (shortest == null || shortest.size() > temp.size())
                shortest = temp;
        }

        return shortest;
    }
}
