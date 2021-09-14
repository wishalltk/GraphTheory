package com.dp;

import java.util.*;

public class BestSum {
    Map<Integer, List<Integer>> memo = new HashMap<>();

    private void updateMemo(int target, List<Integer> value) {
        int valueSize = value.size();
        this.memo.put(target, value);
    }

    List<Integer> bestSum(int target, int[] numbers) {
        System.out.println("bestSum call landed for target = "+target);
        // base conditions
        if(memo.containsKey(target)) {
            System.out.println("base case met: memo recall: "+target+" -> "+memo.get(target));
            return memo.get(target);
        }
        if(target < 0) {
            System.out.println("base case met: target < 0 "+target);
            return null;
        }
        if(target == 0) {
            System.out.println("base case met: target is 0");
            return new ArrayList<>();
        }

        //recursion
        List<Integer> shortest = null;
        System.out.println("shortest init to null\nloop starting");
        for(int num: numbers) {
            System.out.println("*********target = "+target+" loop cnt = "+num+"*********");
            int nt = target-num;
            System.out.println("rec call for new target "+nt);
            List<Integer> tempSolution = bestSum(nt, numbers);
            System.out.println("rec call done for new target "+nt);
            if(tempSolution != null) {
                System.out.println("non null temp solution found");
                List<Integer> list = tempSolution;
                System.out.println("temp solution is "+list);
                list.add(num);
                System.out.println("temp solution after adding loop num "+num+" is "+list);

//                System.out.println("temp solution is "+tempSolution);
//                List<Integer> list = new ArrayList<>();
//                list.add(num);
//                System.out.println("created a new list and added num "+num+" to it \t"+list);
//                list.addAll(tempSolution);
//                System.out.println("new list after adding num and temp "+list);

                if(null == shortest)
                    System.out.println("shortest is null, hence inserting templist into shortest");
                else if(shortest.size() < list.size()) {
                    System.out.println("shortest is in good shape, no need to update , shortrst = "+shortest+", and temp list = "+list);
                } else {
                    System.out.println("overwriting shortlist with templist value , shortrst = "+shortest+", and temp list = "+list);
                }
                if(shortest == null || list.size() < shortest.size())
                    shortest = list;
            } else {
                System.out.println("temp solution is null");
            }
        }
        System.out.println("memo insert key "+target+" values "+shortest);
        updateMemo(target, shortest);
        System.out.println("printing memo "+memo+"\n------------------------------------------------------------------");
        return shortest;
}

    public static void main(String[] args) {
        BestSum bestSum = new BestSum();
        long start = System.currentTimeMillis();
        int[] numbers = {1,2};
        List<Integer> integers = bestSum.bestSum(4,  numbers);
        long end = System.currentTimeMillis();
        System.out.println(integers);
        System.out.println("total runtime " + (end - start));
    }

}
