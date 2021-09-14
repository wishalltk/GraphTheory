package recursion;

import java.util.Arrays;

public class MergeSorting {
    public static void main(String[] args) {
        int[] arr = {5,4,3,1,2};
        doMergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void doMergeSort(int[] arr, int start, int end) {
        // split left and right parts
        // merge them
        if(start > end) return;

        int mid = start+(end-start)/2;
        doMergeSort(arr, start, mid);
        doMergeSort(arr, mid+1, end);



    }
}
