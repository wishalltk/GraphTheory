package com.machinecoding;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        twoPassSolve(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void twoPassSolve(int[] a) {
        int index = a.length-1;
        for(int i = 0;i<index;i++) {
            if(a[i] == 0) {
                int tmp = a[i];
                a[i] = a[index];
                a[index] = tmp;
                index -= 1;
            }
        }

        for(int i=index;i< a.length;i++) {

        }
    }
}
