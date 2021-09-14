package com.arraybased;

import java.util.Arrays;

public class BSNextImmediatePosition {
    /**
     * search and locate the position where the target can be inserted in an ascending order array
     * example
     * target = 5, a[] = {1,3,7,9}
     * Answer is position 2 ; 7 is the next immediate number compared to target*/

    public static void main(String[] args) {
        //         0 1 2 3 4 5
        int[] a = {1,3,5,6,12};
        int target = 6;
        int answer = bSearch(a, target);
        System.out.println("target "+target+" needs to be inserted at the position of element "+a[answer]+" " +
                "which is position # "+answer);
    }

    /*
    * This method will find the position of next big element of
    * given target*/
    private static int bSearch(int[] a, int target) {

        int low = 0;
        int high = a.length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(a[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    /*
     * This method will find the position of next small element of
     * given target*/
    private static int bSearchFloorPos(int[] a, int target) {
        int low=0;
        int high=a.length-1;
        while (low<=high) {
            int mid = low+(high-low)/2;
            if(a[mid] >= target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return high;
    }
}
