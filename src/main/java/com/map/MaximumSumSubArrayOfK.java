package com.map;

import com.arraybased.KSum;

import java.util.*;

public class MaximumSumSubArrayOfK {
    public static void main(String[] args) {
        int[] a = {9,10,9,-7,-4,-8,2,-6};
        int k = 5;
        int[] output = maxSlidingWindow(a, k);
        System.out.println(Arrays.toString(output));
    }

    public static int[] maxSlidingWindow(int[] a, int k) {

        int[] result = new int[a.length+1-k];
        Map<Integer, Integer> map = new HashMap<>();
        SortedSet<Integer> sortedSet= new TreeSet<>();
        for(int i=0;i<k;i++){
            sortedSet.add(a[i]);
            map.merge(a[i], 1, Integer::sum);
        }
        int last;
        int counter = 1;
        result[0]=sortedSet.last();
        for(int i=k;i<a.length;i++) {
            map.merge(a[i], 1, Integer::sum);
            last = a[i-k];
            int c = map.get(last);
            sortedSet.remove(last);
            if(c > 1) {
                for(int z=0;z<c-1;z++)
                    sortedSet.add(last);
            }
            map.put(last, map.get(last)-1);
            sortedSet.add(a[i]);
            int max = sortedSet.last();
            result[counter++]=max;
        }

        return result;
    }

    private static int compute(int[] a, int k) {
        int global = 0;
        for(int i=0;i<k;i++)
            global += a[i];

        int sum = global;
        for(int i=k;i<a.length;i++) {
            sum = sum+a[i]-a[i-k];
            if(sum > global)
                global = sum;
        }
        return global;
    }
}
