package com.arraybased;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        double median = findMedian(arr1, arr2);
        System.out.println("Median is "+median);
    }
// 1,2 ,3,5 ,8,10, 18,20

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0, high = n1;

        while(low <= high) {
            int cut1 = (low+high) >> 1;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;


            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];


            if(left1 <= right2 && left2 <= right1) {
                if( (n1 + n2) % 2 == 0 )
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                else
                    return Math.max(left1, left2);
            }
            else if(left1 > right2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }

    private static double findMedian(int[] arr1, int[] arr2) {
        // we want arr1 to be longer or equal to arr2
        // we want to do binary search on the smallest array to save time
        if(arr2.length<arr1.length) return findMedian(arr2, arr1);

        int n1 = arr1.length;
        int n2 = arr2.length;

        // number of elements we can pick from array1
        int min=0, max=n1;

        while (min<=max) {

            // since the median will divide the merged arrays into 2 equal parts, we will start cutting the
            // the arrays in such a way that left sides of array1 and array2 combined produces the same
            // number of elements as compared to the right side of the median
            // adding +1 will make it work for both odd and even array sizes
            int elementsOneSide = (n1+n2+1)/2 ;

            // prepare cuts
            // cut1 : the index at which we will slice the array1
            // cut vars denote the count of elements, not their indices
            int cut1 = (max+min)/2;

            // cut1 says that we will take that many number of elements on the left side of array 1 & 2 combined
            // so cut2 must have elementsOneSide - cut1 number of nodes

            int cut2 = elementsOneSide-cut1;

            /*
            * as we binary search and move the cuts to the left or right,
            * it can so happen that we might end up taking 0 elements from an array or all of it
            * we need to handle this condition using int min and max constants */

            // find l1, l2, r1, r2
            double l1 = (cut1 == 0)?Integer.MIN_VALUE:arr1[cut1-1];
            double l2 = (cut2 == 0)?Integer.MIN_VALUE:arr2[cut2-1];

            double r1 = (cut1 == n1)?Integer.MAX_VALUE:arr1[cut1];
            double r2 = (cut2 == n2)?Integer.MAX_VALUE:arr2[cut2];

            //lets check if the l1, l2, r1 and r2 are matching the conditions
            if(l1<=r2 && l2<=r1)
            {
                // we can return the median now.
                // if the array length is even, compute average else return the smallest of r1 and r2
                if( (n1+n2)%2 == 0 )
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0D;
                else
                    return Math.max(l1, l2);
            }
            else if(l1 > r2) // we need move left
            {
                max = cut1-1;
            }
            else // l2  is greater than r1. we need to increase the min or move right
            {
                min = cut1+1;
            }

        }
        return 0.0D; // return default;
    }
}
