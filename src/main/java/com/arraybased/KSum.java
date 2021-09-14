package com.arraybased;

public class KSum {
    public static void main(String[] args) {
        int[] a = {2,2,2,2,2,2};
        int sum = 2;
        int ans = sumWays(a, sum);
        System.out.println(ans);
    }

    static int sumWays(int[] a, int sum) {
        int ans = 0;
        int[] dp = new int[a.length];
        dp[0] = a[0];
        if(a[0] == sum)
            ans+=1;
        for(int i=1;i<a.length;i++) {
            if(a[i] == sum) {
                ans+=1;
                dp[i] = sum;
            } else {
                if(dp[i-1]+a[i] == sum) {
                    ans+=1;
                    dp[i] = a[i];
                } else
                    dp[i] = dp[i-1]+a[i];
            }
        }
        return ans;
    }
}
