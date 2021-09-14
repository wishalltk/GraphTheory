package com.aditya.verma;

public class SubSetSum1 {
    private static boolean[][] memo = null;

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 0, 0, 8};
        int W = 11;
        memo = new boolean[W + 1][a.length+1];
        boolean possible = check(a, W, a.length);
        System.out.println(possible);
    }

    private static boolean check(int[] a, int target, int size) {
        // if no elements, we can not make any target sum
        if(size <= 0) return false;

        // if the target is zero, we can always take empty set and make target sum
        if(target == 0) return true;

        if(memo[target][size]) return true;
        // if the current element is greater than target, then we can not take it and
        // we will have to move to next call stack
        if(a[size-1] > target){
            memo[target][size-1] = check(a, target, size-1);
            return memo[target][size-1];
        }

        // now I have 2 choices. reduce the target using current element or do not reduce
        // either way I will move to next call stack, if I get true in either of the calls
        // I will return true;
        boolean p1 = check(a, target-a[size-1], size-1);
        boolean p2 = check(a, target, size-1);
        memo[target-a[size-1]][size-1]  = p1;
        memo[target][size-1] = p2;
        return p1 || p2;
//        return check(a, target-a[size-1], size-1) ||
//                check(a, target, size-1);

    }
}