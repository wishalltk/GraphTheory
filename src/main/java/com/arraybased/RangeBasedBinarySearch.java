package com.arraybased;

public class RangeBasedBinarySearch {
    public static void main(String[] args) {
        int[] a = {5, 7, 8, 8, 8, 8};
        int target = 8;
        int[] positions = findRange(a, target);
        System.out.println("Target "+target+ " is present between "+positions[0]+" and "+positions[1]);
    }

    private static int[] findRange(int[] a, int target) {

        int[] positions = {-1, -1};

        int high = a.length-1;
        int low = 0;
        int index = -1;

        while (low<=high) {
            int mid = low + (high-low)/2;
            if(a[mid] >= target)
                high = mid-1;
            else
                low = mid+1;

            if(a[mid] == target) index = mid;
        }

        positions[0] = index;

        high = a.length-1;
        index = -1;
        while (low <= high) {
            int mid = low+(high-low)/2;
            if(a[mid] <= target)
                low=mid+1;
            else
                high = mid-1;

            if(a[mid] == target) index = mid;
        }
        positions[1] = index;

        return positions;
    }
}
