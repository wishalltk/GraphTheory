package com.dynamicProgramming;
import java.util.*;
public class C_CanSum {
    /*
    * m = target sum
    * n = array length
    *
    * brute force: o(n^m) time, o(m) space
    * DP: o(m*n) time, o(m) space
    * */
    public static void main(String[] args) {
        int[] a = {7,14};
        int target=3000;
        String can = canSum(a, target) ? "Yes": "No";
        System.out.printf("cam sum %d ? %s", target, can);
    }
    private static Map<Integer, Boolean> memo = new HashMap<>();
    private static boolean canSum(int[] a, int target) {
       // if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return true;
        if(target < 0) return false;
        for(int i : a) {
            if(i == 0) continue;
           if(canSum(a, target-i)) {
               memo.put(target, true);
               return true;
           } else {
               memo.put(target, false);
               return false;
           }
        }
        return false;
    }
}
