package com.arraybased;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        int[] a = {1,0,0,0,0,8};
        int target = 9;
        printTriplets(a, target);
    }

    private static void printTriplets(int[] a, int target) {
        List<Integer[]> answer = new ArrayList<>();
        for(int i=0;i< a.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=i+1;j<a.length;j++) {
                int remain = target - (a[i]+a[j]);
                if(map.containsKey(remain))
                    answer.add(new Integer[]{map.get(remain),i,j});
                   // System.out.println(map.get(remain)+","+i+","+j);
                else
                    map.put(a[j], j);
            }
        }
        for(Integer[] item: answer)
            System.out.println(a[item[0]]+"+"+a[item[1]]+"+"+a[item[2]]+"="+target);
    }
}
