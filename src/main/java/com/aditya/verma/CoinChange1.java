package com.aditya.verma;

public class CoinChange1 {
    static int globalCount = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] a = {1,2,5};
        int target = 11;

      int ans =   dfs(a, target);
        System.out.println(ans);
    }

    private static int dfs(int[] a, int target) {
        if(target == 0)
            return 0;
        for(int i=0;i<a.length;i++) {
            int remain = target-a[i];

            if(remain < 0)
                continue;

            int subAns = Math.min(1+dfs(a, remain), dfs(a, target));
            globalCount = Math.min(globalCount, subAns);
        }

        return globalCount == Integer.MIN_VALUE ? -1 : globalCount;
    }
}
