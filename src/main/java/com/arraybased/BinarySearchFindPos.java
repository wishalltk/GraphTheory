package com.arraybased;

public class BinarySearchFindPos {
    public static void main(String[] args) {
        int[] a = {1,3,5,9,11};
        int target = 0;
        int idx = getIndex(a, target);
        System.out.println(target+" should be at index "+idx);
    }

    private static int getIndex(int[] a, int target) {

        int left = 0;
        int right = a.length-1;
        int mid = 0;
        while (left<right) {
            mid = left+(right-left)/2;
            if(a[mid] == target)
            {
                return mid;
            } else if(a[mid]<target)
            {
                left = mid+1;
                right = a.length-1;
            } else {
                left = 0;
                right = mid-1;
            }
        }

        return left;
    }
}
