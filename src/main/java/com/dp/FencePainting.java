package com.dp;

import java.util.HashMap;
import java.util.Map;

public class FencePainting {

    static int[][] costData = new int[3][4];
    static int colorCount = 3;
    static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        FencePainting obj = new FencePainting();
        costData[0][0] = 3;
        costData[0][1] = 5;
        costData[0][2] = 1;
        costData[0][3] = 2;

        costData[1][0] = 2;
        costData[1][1] = 5;
        costData[1][2] = 5;
        costData[1][3] = 2;

        costData[2][0] = 1;
        costData[2][1] = 0;
        costData[2][2] = 5;
        costData[2][3] = 2;

        int minCost=obj.findCost(0, 4);
        long start = System.nanoTime();
        System.out.println("minimum cost = "+minCost);
        System.out.println("runtime "+(System.nanoTime()-start));

    }

    int findCost(int fenceId, int colorId) {
        if(fenceId>3)
            return 0;
        Integer cached = memo.get(fenceId+""+colorId);
        if(cached != null) {
            return cached;
        }
        int minCost = Integer.MAX_VALUE;
        for(int i=0;i<3;i++) {
            if(i==colorId) continue;
            int currentCost = costData[i][fenceId]+findCost(fenceId+1, i);
            if(currentCost<minCost)
                minCost=currentCost;
        }
        memo.put(fenceId + "" + colorId, minCost);
        return minCost;
    }
}
