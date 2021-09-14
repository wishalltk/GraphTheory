package com.recursion;

public class MatrixTraversal {
    public static void main(String[] args) {
        //3x3 matrix
        // start from position 2,2
        MatrixTraversal tx = new MatrixTraversal();
        int ways = tx.travel(2, 3);
        System.out.println(ways);
    }

    int travel(int row, int col) {
        if(row == 0 || col == 0)
            return 0;
        if(row == 1 && col == 1)
            return 1;

        return travel(row-1, col)+travel(row, col-1);
    }
}
