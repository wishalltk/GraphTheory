package com.dp;

import java.util.*;

public class CoinChange {

    private static Map<Integer, List<Integer>> memo = new HashMap<>();
    List<Integer> findChange(int target, int[] coins) {

        List<Integer> cached = memo.get(target);
        if(cached != null)
            return cached;
        if(target < 0)
            return null;
        if(target == 0)
            return new ArrayList<>();
        List<Integer> optimumChange = null;
        for(int coinValue: coins) {
            int newTarget = target - coinValue;
           List<Integer> currentChange = findChange(newTarget, coins);
           if(currentChange == null) {
              // System.out.println("no possible change found for target "+newTarget);
               continue;
           }
           List<Integer> perhapsOptimumChange = new ArrayList<>();
           perhapsOptimumChange.add(coinValue);
           perhapsOptimumChange.addAll(currentChange);

           if(optimumChange == null || perhapsOptimumChange.size() < optimumChange.size())
               optimumChange = perhapsOptimumChange;
        }
        memo.put(target, optimumChange);
        return optimumChange;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,4,100};
        int target = 200;
        List<Integer> optimumChange = new CoinChange().findChange(target, coins);
        System.out.println(optimumChange);
    }

}
