package com.dp.revision;

import java.util.*;



public class CoinChange {
    static int[][] memo;
    static Queue<Long> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) {

        int[] a = {1,2};//{5,37,8,39,33,17,22,32,13,7,10,35,40,2,43,49,46,19,41,1,12,11,28};
        int t = 4;//166; 1111 22 112 121 211
//        System.out.println(bottomUpCoin(a, t));
//        System.out.println("combi "+bottomUpCombination(a, t));
        System.out.println("min coins needed "+minCoinsNeeded(a, t));
//        memo = new int[t+1][a.length+1];
//        for(int[] kk : memo)
//            Arrays.fill(kk, -1);
//        totalWayCount(a, t, a.length);
//        int t1 = totalWayCountViaLoop(a,t, 0);
//        System.out.println("bifurcate = "+memo[t][a.length]+"\nLoop way = "+t1);
        // 96190959
    }

    private static int minCoinsNeeded(int[] coins, int target) {
        int[][] memo = new int[2][target+1];
        // why 2 rows?
        // first row for tracking the number of ways to make the amount which is the index position [ 0 to target ]
        // second row for tracking the coins needed to make the amount which is the index position [ 0 to target ]
        memo[0][0] = 1; // one way to make zero amount ( see the index is 0 )
        memo[1][0] = 0; // zero coin needed to make amount zero
        Map<Integer, List<Integer>> path = new HashMap<>();
        path.put(0, new ArrayList<>());
        for(int i=1;i<=target;i++)
            memo[1][i] = Integer.MAX_VALUE;

        for(int coin: coins) {
            for(int amount=1;amount<=target;amount++) {
                if(coin>amount)
                    continue;
                int remain = amount-coin;
                // 1 coin used here
                if(memo[0][remain] != 0) {
                    memo[0][amount] += memo[0][remain];
                    // check and update coins required
                    memo[1][amount] = Math.min(memo[1][remain]+1, memo[1][amount]);
                    // check and update the path
                    if(path.get(amount) == null || path.get(amount).size() > path.get(remain).size()+1) {
                        List<Integer> tmp = new ArrayList<>(path.get(remain));
                        tmp.add(coin);
                        path.put(amount, tmp);
                    }
                }
            }
        }
        System.out.println("Path is "+path.get(target));
      //  Arrays.stream(memo).forEach(x -> System.out.println(Arrays.toString(x)));
        return memo[1][target];
    }

    private static int bottomUpCoin(int[] coins, int target) {
        int[] memo = new int[target+1];
        memo[0]=1;
        for(int i=1;i<=target;i++) {
            for(int coin: coins) {
                if(coin > i)
                    continue;
                int remain = i - coin;
                if(memo[remain] != 0) {
                    //memo[i] = memo[remain]+1;
                    memo[i] += memo[remain];
                }
            }
        }
        return memo[target];
    }

    private static int bottomUpCombination(int[] coins, int target) {
        int[] memo = new int[target+1];
        memo[0]=1;
        for(int coin: coins) {
            for(int amount=1;amount<=target;amount++) {
                if(coin > amount)
                    continue;
                int remain = amount-coin;
                if(memo[remain] != 0) {
                    memo[amount] += memo[remain];
                }
            }
        }
        return memo[target];
    }


    private static int totalWayCount(int[] a, int t, int length) {
        if(t < 0)
            return 0;
        int cache = memo[t][length];
        if(cache != -1) return cache;
        if(t == 0)
            return 1;

        if(length == 0)
            return 0;

        int tmp =   totalWayCount(a, t-a[length-1], length) + totalWayCount(a, t, length-1);
        memo[t][length] = tmp;
      //  System.out.println("tmp "+tmp);
        return tmp;
    }
//for(int coin=idx; coin<a.length;coin++) {
//            int remain = t-a[coin];
    private static int totalWayCountViaLoop(int[] a, int t, int idx) {
        if(t == 0)
            return 1;
        if(t < 0)
            return 0;
        int sum  =0;
        for(int ptr = idx; ptr<a.length;ptr++) {
            int remain = t-a[ptr];
            int ans = totalWayCountViaLoop(a, remain, ptr);
            sum += ans;
          //  System.out.println(ans);
        }
        return sum;
    }
}
