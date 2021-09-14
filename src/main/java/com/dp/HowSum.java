package com.dp;

import java.util.*;

public class HowSum {

    static Map<Integer, Boolean> memo = new HashMap<>();

    List<Integer> findSum(int[] numbers, int target, List<Integer> solution) {
        if (target == 0) {
            solution = new ArrayList<>();
            return solution;
        }
        for (int number : numbers) {
            int newTarget = target - number;
            if (newTarget < 0) continue;
            solution = findSum(numbers, newTarget, solution);
            if (solution == null)
                memo.put(newTarget, false);
            else {
                solution.add(number);
                return solution;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] numbers = {7, 14, 4, 1};
        List<Integer> solution = new HowSum().findSum(numbers, target, null);
        if (solution == null)
            System.out.println("no solution available");
        else
            System.out.println(solution);
    }

}
