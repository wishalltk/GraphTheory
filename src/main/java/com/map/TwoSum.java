package com.map;
import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        int[] a = {2,2, 7,7, 11, 15};
        int target = 9;
        int[] pairs = twoSum(a, target);
        System.out.println(target+" = "+pairs[0]+" + "+pairs[1]);
    }

    private static int[] twoSum(int[] a, int target) {
        int[] answer = new int[2];
        Arrays.fill(answer, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int cur : a) {
            if (map.containsKey(cur)) {
                answer[0] = cur;
                answer[1] = map.get(cur);
                return answer;
            } else {
                int remain = target - cur;
                map.put(remain, cur);
            }
        }
        return answer;
    }
}
