package recursion;

import java.util.Arrays;

public class SortArrayUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1,5,0,2};
        recSort(arr, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static int recSort(int[] arr, int idx) {
        if(idx == 0) return arr[idx];
        int num = recSort(arr, idx-1);
        int numPos = idx-1;
        for(int i=idx;i<arr.length;i++) {
            if( i != numPos && arr[i] < num) {
                swap(i, numPos, arr);
                numPos = i;
            }
        }
        return num;

    }
}
