package com.dp;

import com.google.common.collect.Lists;
import org.checkerframework.checker.units.qual.C;

import java.util.*;

public class Copied {
    public List<Integer> dynamicBestMemo(int targetSum, List<Integer> numbers) {
        return dynamicBestSumMemo(targetSum, numbers, new HashMap<>());
    }
    private List<Integer> dynamicBestSumMemo(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) { return memo.get(targetSum); }
        if (targetSum < 0) { return null; }
        if (targetSum == 0) { return new ArrayList<>(); }
        List<Integer> shortest = null;
        for (Integer value : numbers)  {
            List<Integer> combination = dynamicBestSumMemo(targetSum - value, numbers, memo);
            if (combination != null) {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                list.addAll(combination);
                if (shortest == null || shortest.size() > list.size()) {
                    shortest = list;
                }
            }
        }
        memo.put(targetSum, shortest);
        return shortest;
    }

    public static void main(String[] args) {
        int target = 100;
        List<Integer> numbers = Lists.newArrayList(1,2,5,25);
        Copied obj = new Copied();
        List<Integer> bestMemo = obj.dynamicBestMemo(target, numbers);
        System.out.println(bestMemo);
    }
}
