package com.matrix;

import java.util.Arrays;

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];

        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[0][2] = 5;
        matrix[0][3] = 7;

        matrix[1][0] = 10;
        matrix[1][1] = 11;
        matrix[1][2] = 16;
        matrix[1][3] = 20;

        matrix[2][0] = 23;
        matrix[2][1] = 30;
        matrix[2][2] = 34;
        matrix[2][3] = 50;

        int target = 50;
        boolean found = topDownSearch(matrix, target);
        System.out.println("element "+target+" found in matrix ? "+found);
    }

    private static boolean topDownSearch(int[][] matrix, int target) {
        //return doSearch(0,0,matrix.length, matrix[0].length, target, matrix);
        int rowId = binarySearchForRow(0, matrix.length-1, matrix, target);
        return binarySearchInRow(matrix, rowId, target);
        //System.out.println(rowId);
        //return false;
    }

    private static boolean binarySearchInRow(int[][] matrix, int rowId, int target) {
        int r = matrix[rowId].length-1;
        int l = 0;
        return doBinarySearchInMatrix(l, r, matrix[rowId], target);
    }

    private static boolean doBinarySearchInMatrix(int l, int r, int[] row, int target) {
        if(l>r) return false;
        int mid = l + (r-l)/2;
        if(row[mid] == target)
            return true;
        else if(row[mid] < target)
            return doBinarySearchInMatrix(mid+1, r, row, target);
        else
            return doBinarySearchInMatrix(l, mid-1, row, target);
    }

    private static int binarySearchForRow(int startRow, int endRow, int[][] matrix, int target) {
        if(startRow == endRow) return startRow;
        int midRowId = (endRow-startRow == 1)?endRow : startRow + (endRow-startRow)/2;
        int midRowFirstElement = matrix[midRowId][0];
        if(midRowFirstElement == target) return midRowId;
        else if(midRowFirstElement > target) return binarySearchForRow(startRow, midRowId-1, matrix, target);
        else return binarySearchForRow(midRowId, endRow, matrix, target);
    }


    private static boolean doSearch(int rowStart, int colStart, int rowEnd, int colEnd, int target, int[][] matrix) {
        if(rowStart > rowEnd || colStart > colEnd) return false;
        int midRow = rowStart + (rowEnd-rowStart)/2;
        int midCol = colStart + (colEnd-colStart)/2;
        int midValue = matrix[midRow][midCol];
        if(midValue == target) return true;
      //  else if(midValue < target) return doSearch()
        return false;
    }

    private static boolean linearSearch(int[][] matrix, int target) {
        for (int[] rows : matrix) {
            for (int column : rows) {
                if (rows[column] == target) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean searchInMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int colLength = matrix[0].length;
        int rowMid = length/2;
        int colMid = colLength/2;
        int midVal = matrix[rowMid][colMid];
        if(midVal == target) return true;
        else if(midVal<target) return doMatrixBinarySearch(rowMid, colMid+1, length, colLength, target, matrix);
        else return doMatrixBinarySearch(0,0,rowMid, colMid, target, matrix);
    }

    private static boolean doMatrixBinarySearch(int rowStart, int colStart, int rowEnd, int colEnd, int target, int[][] matrix) {
        if(rowStart>rowEnd || colStart>colEnd) return false;
        int rowMid = rowStart+(rowEnd-rowStart)/2;
        int colMid = colStart + (colEnd-colStart)/2;
        if(matrix[rowMid][colMid] == target) return true;

        return false;
    }
}
