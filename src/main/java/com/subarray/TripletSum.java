package com.subarray;

import java.util.*;

public class TripletSum {
    public static void main(String[] args) {
        int[] a = {1, 0, 2, -1, 5};
        triplets(a, 0);
    }

    static void triplets(int[] a, int t) {

        Map<Integer, Integer>  map  = new HashMap<>(a.length);
        for(int i=1;i<a.length;i++) {
            for(int j=0;j<i;j++){
                int sum = -1*(a[i]+a[j]);
                if(map.containsKey(sum)) {
                    int pos =  map.get(sum);
                    if(pos != j && pos != i) {
                        System.out.println(sum+","+a[i]+","+a[j]);
                      return;
                    }
                } else {
                    map.put(a[j], j);
                }
            }
        }
        System.out.println("not found");

    }

    static void findTriplets(int[] arr, int n) {
        boolean found = false;

        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to
            // "-arr[i]"
            HashSet<Integer> s = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x)) {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                    found = true;
                } else {
                    s.add(arr[i]);
                }
            }
        }

        if (!found) {
            System.out.print(" No Triplet Found\n");
        }
    }
}
