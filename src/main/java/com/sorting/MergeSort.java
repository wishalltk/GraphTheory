package com.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {1,3,2,4,9,7,6};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(a, 0, a.length-1);
        System.out.println(a);

    }

    void mergeSort(int[] a, int l, int r) {
        if(l>=r)
            return ;
        int mid = (l + (r-l))/2;
        mergeSort(a, l, mid);
        mergeSort(a, mid+1, r);
        sort(a, l, mid, r);

    }

    void sort(int[] a, int l, int mid, int r) {
        int[] b = new int[r-l+1];
        int lp = l;
        int rp = mid+1;
        int k = l;
        while (lp <= mid && rp <= r){
            if(a[lp] < a[rp]) {
                b[k]=a[lp];
                lp++;
            } else {
                b[k]=a[rp];
                rp++;
            }
            k++;
        }

        // check if left array exhausted, in such case, left pointer would've moved past the mid
        if(lp > mid) {
            // if so, copy the remaining elements to b array from right array
            while (rp <= r){
                b[k++] = a[rp++];
            }
        }
        else {
            //right pointer exhausted
            while (lp <= mid)
                b[k++] = a[lp++];
        }


        for(k=l;k<=r;k++)
            a[k]=b[k];
    }

}
