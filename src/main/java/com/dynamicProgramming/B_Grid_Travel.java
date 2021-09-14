package com.dynamicProgramming;
import java.util.*;
public class B_Grid_Travel {
    /*
    * Consider what happens when you have only 2 grids [[0,0]], start is the end
    * Try to decrease the problem size step by step
    * Brute force
    * Time 2^(m+n)
    * O(m+n) space
    *
    * Memo
    * same space but O(m*n) time
    * */

    public static void main(String[] args) {
//        int[][] grid = new int[3][3];
//        grid[0][0]=1;
//        grid[0][1]=0;
//        grid[0][2]=0;
//
//        grid[1][0]=1;
//        grid[1][1]=1;
//        grid[1][2]=0;
//
//        grid[2][0]=0;
//        grid[2][1]=1;
//        grid[2][2]=1;
        int rowsCount = 30;
        int colsCount = 30;
        int ways = numOfWaysToTravel(rowsCount, colsCount);
        System.out.printf("with %d rows and %d cols, you can travel in %d number of ways%n", rowsCount, colsCount, ways);
    }
    static Map<String, Integer> memo = new HashMap<>();
    private static int numOfWaysToTravel(int rowsCount, int colsCount) {
        String key = rowsCount+"_"+colsCount;
        if(memo.containsKey(key)) return memo.get(key);
        if(rowsCount == 1 && colsCount == 1)
            return 1;
        if(rowsCount == 0 || colsCount == 0)
            return 0;
        int temp =  numOfWaysToTravel(rowsCount-1, colsCount)+numOfWaysToTravel(rowsCount, colsCount-1);
        memo.put(key, temp);
        return temp;
    }
}
