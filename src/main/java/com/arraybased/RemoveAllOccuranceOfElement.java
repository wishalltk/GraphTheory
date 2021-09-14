package com.arraybased;

import java.util.Arrays;

public class RemoveAllOccuranceOfElement {

    public static void main(String[] args) {
        int[] a = {1,0,2,0,3,0,0,0,0,1};
        int k = 0;

        int s = removeKFromA(a, k);
        System.out.println("length = "+s+"\n"+ Arrays.toString(a));

    }

    private static int removeKFromA(int[] a, int k) {
        int left = 0;
        int right = a.length-1;
        int counter = 0;
        while (left<right) {
            // if a[left]  == 0 ~ pause the left ptr
            // if a[right =! 0 ~ swapthem
            // if a[right] == 0 ~ increment right ptr
            // if a[left] != 0 ~ increment

            if(a[left] == 0) {
                if(a[right] == 0)
                    right--;
                else {
                    swap(a, left, right);
                    left++;
                    right--;
                    counter++;
                }
            } else {
                left++;
                counter++;
            }
        }
        return counter;
    }

    private static void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }
}
