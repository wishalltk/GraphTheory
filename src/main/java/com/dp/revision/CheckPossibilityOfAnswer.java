package com.dp.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckPossibilityOfAnswer {
    public static void main(String[] args) {
        CheckPossibilityOfAnswer instance = new CheckPossibilityOfAnswer();
      //  int[] coins = {5,37,8,39,33,17,22,32,13,7,10,35,40,2,43,49,46,19,41,1,12,11,28};
       // int target = 166;
        int[] coins = {2,1};
        int target = 4;
        //answer = 96190959
        int ss = 96190959;
        boolean possibility = instance.checkIfChangePossibleLoopWay(coins, target);
        boolean p2 = instance.checkIfPossibleNonLoopWay(coins, target, coins.length-1, new ArrayList<>());
        System.out.println("result "+possibility+" "+p2);
        System.exit(0);
        instance.coinChangePossibility(coins, target);
        instance.coinChangeOnePossibleWay(coins, target);
        instance.coinChangeAllPossibleWays(coins, target);
        instance.coinChangePossibleWaysCount(coins, target);
        instance.coinChangePossibleMinCoins(coins, target);
    }

//    int countPossibleWays(int[] coins, int target, int index) {
//        if(target == 0) return 1;
//        if(target < 0) return 0;
//        if(index < 0) return 0;
//
 //            int remain = target-coin;
//            countPossibleWays(coins, remain, index);
//        }
//    }

    boolean checkIfPossibleNonLoopWay(int[] coins, int target, int index, List<Integer> coinsUsed) {
    //    System.out.println("target = "+target+" index = "+index);
        if(target == 0) {
      //      System.out.println(" ### Success using "+coinsUsed);
            coinsUsed.clear();
            return true;
        }
        if(target < 0) {
    //        System.out.println("### Failure using "+coinsUsed);
            return false;
        }
        if(index < 0) {
  //          System.out.println("### Failure using "+coinsUsed);
            return false;
        }

        int currentCoin = coins[index];
     //   System.out.println(" **** Coin used is "+currentCoin);
     //   System.out.println("Left : target = "+(target-currentCoin)+" index = "+index);
//        coinsUsed.add(currentCoin);
        System.out.println("Using coin "+currentCoin);
        boolean way1 =  checkIfPossibleNonLoopWay(coins, target-currentCoin, index, coinsUsed);
        if(way1) System.out.println(currentCoin+" helped");
       // System.out.println("\tRight : target = "+(target)+" index = "+index);
        boolean way2 =  checkIfPossibleNonLoopWay(coins, target, index-1, coinsUsed);
        if(way2) System.out.println(currentCoin+" helped");
//        if(way1) System.out.println("way1 possible");
//        if(way2) System.out.println("way2 possible");
       // if(way1 || way2) System.out.println("possible");
        return way1 || way2;
    }

    boolean checkIfChangePossibleLoopWay(int[] coins, int target) {
        if(target == 0)
            return true;
        if(target < 0)
            return false;

        //for loop way
        for(int coin: coins) {
            int remain = target-coin;
            if(checkIfChangePossibleLoopWay(coins, remain))
                return true;
        }
        return false;


    }
    int minCoins = -1;
    int[][] memo5 = null;
    private void coinChangePossibleMinCoins(int[] coins, int target) {
        // find the minimum number of coins to make the change
        // need to track how many coins are used in each way
        memo5 = new int[coins.length+1][target+1];
        for(int[] a : memo5)
            Arrays.fill(a, -1);
        int tc = dfs5(coins, target, coins.length, 0);
        System.out.println("total="+tc+" min="+minCoins);

    }

    private int dfs5(int[] coins, int target, int length, int usedCount) {

       // if(memo5[length][target] != -1) return memo5[length][target];
        if(target == 0)
            return 1;
        if(length == 0)
            return 0;

        int way1 = dfs5(coins, target, length-1, usedCount);
        if(coins[length-1] > target) return dfs5(coins, target, length-1, usedCount);
        int remain = target-coins[length-1];
        int way2 = dfs5(coins, remain, length, usedCount+1);
        if((way1 > 0 || way2 > 0) && usedCount != 0) {
            if(minCoins == -1)
                minCoins = usedCount;
            else
                minCoins = Math.min(minCoins, usedCount);
        }
        //memo5[length][target] = way1+way2;
        return way1+way2;
    }

    int[][] memo = null;
    void coinChangePossibleWaysCount(int[] coins, int target) {
        memo = new int[coins.length+1][target+1];
        for(int[] a : memo)
            Arrays.fill(a, -1);
        int waysCount = dfs4(coins, target,coins.length);
        System.out.println("Make " + target + " from " + Arrays.toString(coins) + " => " + waysCount+" ways");
    }

    private int dfs4(int[] coins, int target, int length) {
    //    if(memo[length][target] != -1) return memo[length][target];
        if(target == 0) return 1;
        if(length == 0) return 0;
        int currentCoinValue = coins[length-1];
        int remain = target-currentCoinValue;
        if(remain < 0) return dfs4(coins, target, length-1);
        int ans1 = dfs4(coins, target, length-1);
        int ans2 = dfs4(coins, remain, length);
    //    System.out.println("skip "+ans1+" ~ included "+ans2);
        int ans = ans1 + ans2;
    //    memo[length][target] = ans;
        return ans;
    }

    void coinChangePossibility(int[] coins, int target) {
        boolean isPossible = dfs1(coins, target);
        System.out.println("Make " + target + " from " + Arrays.toString(coins) + " => " + isPossible);
    }

    void coinChangeOnePossibleWay(int[] coins, int target) {
        List<Integer> path = dfs2(coins, target);
        if (path == null) {
            System.out.println("Impossible to make " + target + " from " + Arrays.toString(coins));
        } else {
            System.out.println("One way to make " + target + " from " + Arrays.toString(coins) + " is ");
            System.out.println(path);
        }
    }

    void coinChangeAllPossibleWays(int[] coins, int target) {
        List<List<Integer>> allWays = dfs3(coins, target);
        if (allWays == null) {
            System.out.println("Impossible to make " + target + " from " + Arrays.toString(coins));
        } else {
            System.out.println("All the ways to make " + target + " from " + Arrays.toString(coins) + " are ");
            System.out.println(allWays);
        }
    }

    private List<List<Integer>> dfs3(int[] coins, int target) {
        if (target == 0)
            return new ArrayList<>();
        if(target < 0)
            return null;
        List<List<Integer>> result = new ArrayList<>();
        for (int coin : coins) {
            int remain = target - coin;
           List<List<Integer>> list = dfs3(coins, remain);
           if(list != null) {
               if(list.isEmpty()) list.add(new ArrayList<>());
               list.forEach(l->l.add(coin));
               result.addAll(list);
           }
        }
        return result;
    }

    private List<Integer> dfs2(int[] coins, int target) {
        if (target < 0) return null;
        if (target == 0) return new ArrayList<>();

        for (int coin : coins) {
            int remain = target - coin;
            List<Integer> nullable = dfs2(coins, remain);
            if (nullable != null) {
                nullable.add(coin);
                return nullable; // early exit since we need only one possible combination
            } // do nothing if it is null, we need to check other possibilities
        }
        return null;
    }

    private boolean dfs1(int[] coins, int target) {
        if (target == 0) return true;
        if (target < 0) return false;

        // unbounded sack, hence loop is needed
        for (int coin : coins) {
            int newTarget = target - coin;
            boolean isPossible = dfs1(coins, newTarget);
            if (isPossible) return true;
        }
        // if we did not return from loop that means the coin change is not possible
        return false;
    }
}
