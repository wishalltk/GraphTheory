package com.aditya.verma;

import java.util.*;

public class UnboundedKnapsack {

    static Map<Integer, Boolean> canSumMemo = new HashMap<>();
    static Map<Integer, List<Integer>> howSumMemo = new HashMap<>();

    public static void main(String[] args) {
        int[] a = {400, 100};
        int target = 800;

        boolean canSum = canSum(a, target);

        List<Integer> howSum = howSum(a, target);

        Integer sumWays =  sumWays(a, target);

        System.out.println("can sum ? " + canSum + "\n how sum = " + howSum+"\n Sum ways "+sumWays);
    }

    private static Integer sumWays(int[] coins, int target) {
        if(target == 0)
            return 0;
        if(target < 0)
            return null;
        for(int coin: coins) {
            int newTarget = target-coin;
            Integer tmp = sumWays(coins, newTarget);
            if(tmp != null) {
                tmp+=1;
                return tmp;
            }
        }
        return null;
    }


    private static List<Integer> howSum(int[] coins, int target) {
        if (target == 0)
            return new ArrayList<>();
        if (target < 0)
            return null;
        if(howSumMemo.containsKey(target))
            return howSumMemo.get(target);
        for (int coin : coins) {
            int balance = target - coin;
            List<Integer> nullable = howSum(coins, balance);
            if (nullable != null) {
                nullable.add(coin);
                howSumMemo.put(balance, nullable);
                return nullable;
            }
        }
        howSumMemo.put(target, null);
        return null;
    }

    private static boolean canSum(int[] coins, int target) {
        if (target == 0) return true;
        if (target < 0) return false;
        if (canSumMemo.containsKey(target)) return canSumMemo.get(target);
        for (int coin : coins) {
            if (coin <= target) {
                int balance = target - coin;
                boolean tempAnswer = canSum(coins, balance);
                if (tempAnswer) {
                    canSumMemo.put(balance, true);
                    return true;
                }
            }
        }
        canSumMemo.put(target, false);
        return false;
    }


}
