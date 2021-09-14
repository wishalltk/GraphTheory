package com.arraybased;

public class MinSizeSubArrayForSum {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int t = 11;
       // onePass(a, t);
        int ans = test(a, t);
        System.out.println(ans);
        nSquareSolution(a, t);
        System.out.println("easy "+easy(a, t));
    }

    static int easy(int[] arr, int k){
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;

        while (j < arr.length) {
            sum += arr[j];
            if (sum >= k) {
                while (sum >= k && i <= j) {
                    min=Math.min(min,j-i+1);
                    sum -= arr[i];
                    i++;
                }
            }
            j++;
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }

    static int test(int[] nums, int s) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    static void onePass(int[] a, int t) {
        int sp = 0;
        int fp = 0;
        int sum = 0;
        int localMin, globalMin = 0;
        while (fp < a.length && sp < a.length) {
           sum += a[fp];
           if(sum < t) {
               fp++;
           } else if(sum > t) {
               sum -= a[sp];
               sum -= a[fp];
               sp++;
           } else {
               localMin = fp-sp+1;
               if(globalMin == 0) globalMin=localMin;
               else globalMin = Math.min(localMin, globalMin);
               sum -= a[sp];
               sp++;
           }

        }
        System.out.println(globalMin);
    }

    static void nSquareSolution(int[] a, int t){
        int local = 0;
        int global = 0;

        for(int i=0;i<a.length;i++) {
            int sum = 0;
            for(int j=i;j<a.length;j++) {
                sum += a[j];
                if(sum == t) {
                    local = j-i+1;
                    if(global == 0) global = local;
                    else global = Math.min(local, global);
                } else if(sum > t) {
                    break;
                }
            }
        }
        System.out.println(global);
    }
}
