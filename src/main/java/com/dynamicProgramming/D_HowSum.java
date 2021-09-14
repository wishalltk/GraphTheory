package com.dynamicProgramming;
import java.util.*;
public class D_HowSum {
    public static void main(String[] args) {
        int[] a = {3,5,4,7};
        int target = 7;
        List<Integer> answer = howToSum(a, target);
        assert answer != null;
        for(Integer list : answer)
            System.out.print(list+"\t");
    }
    static Map<Integer, List<Integer>> map = new HashMap<>();
    private static List<Integer> howToSum(int[] a, int target) {
        if(map.containsKey(target)) return map.get(target);
        if(target == 0)
            return new ArrayList<>();
        if(target < 0)
            return null;
        for(int i: a) {
            int rem = target-i;
            List<Integer> temp = howToSum(a, rem);
            if(null != temp) {
                temp.add(i);
                map.put(i, temp);
                return temp;
            }
        }
        return null;
    }


}
