package com.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {0,3,0,0,0,1,2,3,3,2,1};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void selectionSort(int[] a) {

        for(int i=0;i<a.length-1;i++) {
            int minIndex = i;
            int j;
            for(j=i+1; j<a.length;j++) {
                if(a[j] < a[minIndex])
                    minIndex = j;
            }
            if(minIndex != i) {
                int tmp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = tmp;
            }
        }
    }
}
