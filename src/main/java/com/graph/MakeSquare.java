package com.graph;

public class MakeSquare {

    public static void main(String[] args) {
        int[] matchsticks = {1, 1, 2, 2, 2};
        MakeSquare makeSquare = new MakeSquare();
        boolean answer = makeSquare.makeSquare(matchsticks);
        System.out.println("Answer = "+answer);
    }

    public boolean makeSquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int stick : matchsticks)    sum = sum + stick;

        if (sum % 4 != 0) {
            return false;
        }
        int side1 = 0, side2 = 0, side3 = 0, side4 = 0, currIndex = 0;

        int oneSideLen = sum/4;

        return dfs (side1, side2, side3, side4, matchsticks, currIndex, oneSideLen);

    }
    public boolean dfs (int s1, int s2, int s3, int s4, int arr[], int k, int len) {
        if (s1 > len || s2 > len || s3 > len || s4 > len) {
            return false;
        }
        if (k == arr.length) {
            return s1 == s2 && s2 == s3 && s3 == s4;
        }

        return (dfs (s1 + arr[k], s2         , s3         , s4         , arr, k + 1, len) ||
                dfs (s1         , s2 + arr[k], s3         , s4         , arr, k + 1, len) ||
                dfs (s1         , s2         , s3 + arr[k], s4         , arr, k + 1, len) ||
                dfs (s1         , s2         , s3         , s4 + arr[k], arr, k + 1, len));
    }
}
