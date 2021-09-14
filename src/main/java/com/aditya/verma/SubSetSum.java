package com.aditya.verma;

public class SubSetSum {
    static int[][] t = null;

    public static void main(String[] args) {
        int[] a = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        t = new int[a.length + 1][target + 1];
        //boolean isPossible = isPossible(a, t, a.length);
        int isPossible = numOfWaysTopDown(a, target, a.length);
        System.out.println(isPossible);
    }

    private static boolean isPossible(int[] a, int t, int size) {
        if (size == 0) return false;

        if (t == 0) return true;

        if (a[size - 1] > t) return isPossible(a, t, size - 1);

        return isPossible(a, t - a[size - 1], size - 1) || isPossible(a, t, size - 1);
    }

    private static int numOfWaysTopDown(int[] a, int target, int size) {

        for (int i = 0, j = 0; i <= size && j <= target; i++, j++) {
            if (i == 0) t[i][j] = 0;
            if (j == 0) t[i][j] = 1;
        }

        //iteration
        for (int i = 1; i <= size; i++) { // rows -- element size
            for (int j = 1; j <= target; j++) { // columns -- target sum
                if (a[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - a[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[size][target];
    }

    private static int howManyPossibilities(int[] a, int t, int size) {
        if (size == 0 || t < 0) return 0;

        if (t == 0) return 1;

        if (a[size - 1] > t)
            return howManyPossibilities(a, t, size - 1);
        else
            return howManyPossibilities(a, t - a[size - 1], size - 1) + howManyPossibilities(a, t, size - 1);

    }
}
