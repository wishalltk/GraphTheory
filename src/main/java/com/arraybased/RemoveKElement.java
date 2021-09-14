package com.arraybased;

public class RemoveKElement {
    public static void main(String[] args) {
        int[] input = {3, 3};
        int n = 3;
        int k = removeElement(input, n);
        System.out.println("k is "+k);
    }

    static int removeElement(int[] a, int val) {
        int k = a.length;
        int left = 0;
        int right = a.length-1;

        while (left <= right) {
            if(a[left] != val) {
                left += 1;
              //  k -= 1;
            } else {
                //a[left] == val // needs to be removed
                if(a[right] == val) {
                    right -= 1;
                    k-=1;
                }
                else {
                    // non val value in the right
                    swap(left, right, a);
                    left+=1;
                    right-=1;
                    k -= 1;
                }
            }
        }
    return k;
    }

    static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
