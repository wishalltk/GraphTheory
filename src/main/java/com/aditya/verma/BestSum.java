package com.aditya.verma;
import java.util.*;
public class BestSum {
    static Map<Integer, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        //int[] coins = {186,419,83,408};
        //int target = 6249;
        int[] coins = {2,2};
        int target = 3;
        long start = System.currentTimeMillis();
        Integer leastCoins = leastCoinsForSum(coins, target);
        long end = System.currentTimeMillis();
        System.out.println(leastCoins+" in "+(end-start));
        Integer nullableInt = numWays(coins, target);
        System.out.println("num ways "+(nullableInt == null ? -1 : nullableInt));
    }

//    private static List<Integer> shortestCombo(int[] coins, int target) {
//        if(target == 0)
//            return new ArrayList<>();
//        if(target < 0)
//            return null;
//
//
//    }

    private static Integer numWays(int[] coins, int target) {
        if(target == 0)
            return 0;

        if(target < 0)
            return null;

        for(int coin : coins) {
            int remaining = target-coin;
            Integer tmp = numWays(coins, remaining);
            if(tmp != null)
                return tmp+1;
        }
        return null;
    }

    private static Integer leastCoinsForSum(int[] coins, int target) {
        Integer bestAnswer = null;
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0)
            return 0;
        if(target < 0)
            return null;

        for(int coin : coins) {
            int balance = target-coin;
            Integer tmp = leastCoinsForSum(coins, balance);
            if(tmp != null){
                tmp = tmp+1;
                bestAnswer = bestAnswer == null ? tmp : Math.min(bestAnswer, tmp);
            }
        }
        memo.put(target, bestAnswer);
        return bestAnswer;
    }
}
