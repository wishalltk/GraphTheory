package com.dp;

public class GridTraveller {

    long[][] memo = null;

    long travel(int rowId, int colId) {
        if(rowId == 1 && colId == 1) return 1;
        if(memo[rowId][colId] == 0 && memo[colId][rowId] == 0) {
            long leftSum = 0, rightSum = 0;
            if(rowId > 0)
                leftSum = travel(rowId-1, colId);
            if(colId > 0)
                rightSum = travel(rowId, colId-1);
            memo[rowId][colId] = leftSum+rightSum;
        }
        return memo[rowId][colId]==0?memo[colId][rowId]:memo[rowId][colId];

    }

    public static void main(String[] args) {
        GridTraveller traveller = new GridTraveller();
        int rows = 3;
        int cols = 3;
        traveller.memo = new long[rows+1][cols+1];
        long start = System.nanoTime();
        long ways = traveller.travel(rows,cols);
        long end = System.nanoTime();
        System.out.println(ways+" ways, took "+(end-start) +" nano seconds");
    }

}
