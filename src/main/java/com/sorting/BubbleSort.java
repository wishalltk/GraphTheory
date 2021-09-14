package com.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {0,1,0,3,12};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(input);
        System.out.println("Final Sorted " + Arrays.toString(input));
    }


    void bubbleSort(int[] ar) {
        // take one element, compare it with the next one, if it is greater, swap it and keep it going
        int limit = ar.length - 1;

        for (int j = 0; j < ar.length; j++) {
            boolean swapped = false;
            System.out.println("outer loop count " + (j + 1));
            for (int i = 0; i < limit; i++) {
                System.out.println("\tinner loop count " + (i + 1));
                int left = ar[i];
                int right = ar[i + 1];
                if (left > right) {
                    swap(i, i + 1, ar);
                    swapped = true;
                }
            }
            if(!swapped) {
                System.out.println("early exit since no swapping happened");
                break;
            }
            limit -= 1;
        }

    }

    void swap(int a, int b, int[] ar) {
        int tmp = ar[a];
        ar[a] = ar[b];
        ar[b] = tmp;
    }

    public void moveZeroes(int[] nums) {
        int[] a = nums;
        if (a.length < 2)
            return;
        int sp = 0;
        int fp = 1;

        while (fp<a.length) {
            /*if (fp == a.length - 1) {
                if (a[fp] == 0 && a[sp] != 0) {
                    swap(sp, fp, a);
                }
                break;
            }*/

            if (a[sp] == 0) {
                if (a[fp] == 0) {
                    fp += 1;
                } else {
                    //fp is non-zero
                    swap(sp, fp, nums);
                    sp += 1;
                    fp += 1;
                }
            } else {
                //sp is non zero
                sp += 1;
                fp += 1;
            }
        }


    }
}
