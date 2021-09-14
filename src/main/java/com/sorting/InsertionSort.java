package com.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {0, 3, 0, 3, 0, 0, 0};
        new InsertionSort().insSort(a);
        System.out.println(Arrays.toString(a));
    }

    void insSort(int[] a){
        for(int i=1;i<a.length;i++) {
            int key = a[i];
            int j = i;
            while (j > 0) {
                if(a[j-1] > key)
                    a[j] = a[j-1];
                else
                    a[j] = key;
                j -= 1;
            }
        }
    }

    void insertionZort(int[] a) {

        for(int i=1;i<a.length;i++) {
            int key = a[i];
            int j=i;
            while (j>0){
                if(a[j-1] > a[j])
                    a[j] = a[j-1];
                else
                    a[j] = key;
                j-=1;
            }
        }
    }

    void insertionSort(int[] a) {
        for(int i=1;i<a.length;i++) {
            int key = a[i];
            int j = i;
            while (j > 0) {
                if (a[j] < a[j-1])
                    a[j]=a[j-1];
                else
                    a[j] = key;
                j-=1;
            }
        }
    }
}
