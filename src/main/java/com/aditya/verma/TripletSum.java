package com.aditya.verma;

public class TripletSum {
    public static void main(String[] args) {
        int[] a = {1,0,2,8,3,6};
        int target = 10;
        boolean possible = isPossible(a, target, 3, a.length);
        System.out.println(possible);
    }
static int ogTarget = 13;
    private static boolean isPossible(int[] a, int target, int itemsLeft, int size) {

        // base conditions
        if(target == 0 && itemsLeft == 0) return true;

        if(itemsLeft == 0 || size == 0) return false;

        // if the current element is bigger than the target, then
        // we need to discard it and move to next call stack

        if(a[size-1] > target) {
            return isPossible(a, ogTarget, 3, size-1);
        }

        // for each element I have 2 options, either reduce it from the target and
        // move to next stack or do not consider it and move to next
        boolean op1 = isPossible(a, target-a[size-1], itemsLeft-1, size-1);
        boolean op2 = isPossible(a, target, itemsLeft, size-1);

        return op1 || op2;
    }
}
