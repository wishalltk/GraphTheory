package com.dp;

import java.util.*;

public class CanSum {

    Map<Integer, Boolean> memo = new HashMap<>();
    Stack<Integer> answer = new Stack<>();

    boolean recMethod1(int[] values, int target) {

        if(memo.containsKey(target))
            return memo.get(target);

        if (target == 0) {
            return true;
        }
        for (int value : values) {
            int newTarget = target - value;
            if(newTarget < 0)
                continue;
            boolean can = recMethod1(values, newTarget);
            //memo.put(newTarget, can);
            if(can) {
                answer.push(value);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        int[] a = {7, 14, 1};
        int target = 22;
        CanSum sum = new CanSum();
        long start = System.currentTimeMillis();
        boolean can = sum.recMethod1(a, target);
        long end = System.currentTimeMillis();
        System.out.println("runtime " + (end - start) + " ms");
        System.out.println("target possible = " + can);
        while (!sum.answer.isEmpty())
            System.out.print(sum.answer.pop()+"\t");
    }

}
