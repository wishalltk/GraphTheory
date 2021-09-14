package com.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3,2,2,3,3,3,3,3,3,3,3,3};
        quickSort( 0, a.length-1, a);
        System.out.println(Arrays.toString(a));
    }

    static void quickSort(int left, int right, int[] a){
        System.out.println("rec loop");
        //base case
        if(left >= right)
            return;

        //compute the value of element in the middle
        int midVal = a[(left+right)/2];

        //get the midVal moved to a sorted position
        int sortedPosition = divideAndSort(left, right, midVal, a);

        //now that we have sortedPosition, run the rec method for both sides
        quickSort(left, sortedPosition-1, a);
        quickSort(sortedPosition, right, a);
    }

    private static int divideAndSort(int left, int right, int midVal, int[] a) {
        while (left<right) {
            System.out.println("divide loop");
            // move the left cursor as long as items in the left of mid value is less than equal to it.
            while (a[left] < midVal)
                left++;
            // move the right cursor as long as items in the right side of mid value is greater than equal to it.
            while (a[right] > midVal)
                right--;
            // once the order is broken, swap the left and right
            if(left <= right) {
                swap(a, left, right);
                left++;
                right--;
            }

        }
        // when this loop completes, left and right will be in the same position
        // and that is position where the element sits in its sorted location
        // return it to the quicksort method so that we can sort the left and right sides part of the array
        // in 2 rec calls
        return left;
    }

    private static void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }
}
