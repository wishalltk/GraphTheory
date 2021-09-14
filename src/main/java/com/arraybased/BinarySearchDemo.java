package com.arraybased;

public class BinarySearchDemo {
    static int iterations = 0;
    public static void main(String[] args) {
        int[] a = {1,2,4,};
        int target = 0;
        boolean found = binarySearch(a, target);
        System.out.println(target+" found = "+found+" in iterations = "+iterations+" in an array of size = "+a.length);
    }

    private static boolean binarySearch(int[] a, int target) {
        return binarySearch(0, a.length-1, target, a);
    }

    static boolean binarySearch(int l, int r, int target, int[] a) {
        iterations++;

        if(l>r) return false;
        int mid = (l+ (r-l)/2);
        if(a[mid] == target)
            return true;
        else if(a[mid] < target) //move to right
            return binarySearch(mid+1, r, target, a);
        else
            return binarySearch(l, mid-1, target, a);
    }
}
