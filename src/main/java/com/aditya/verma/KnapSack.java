package com.aditya.verma;

public class KnapSack {
    static int[][] memo = null;
    static int[][] t = null;
    public static void main(String[] args) {
        int[] weight = {4, 4, 5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5, 9, 7, 6, 1, 10, 1, 1, 7, 2, 4, 9, 10, 4, 5, 5, 7};
        int[] cost = {468, 335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828, 437, 392, 605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36, 895, 704, 812, 323};
        int W = 841;
        memo = new int[W+1][weight.length+1];
        t = new int[weight.length+1][W+1];
       // int maxProfit = topDown(weight, cost, W, weight.length);
        int maxProfit = ksRec(weight, cost, W, weight.length);
        int correctAnswer = 24576;
        if(maxProfit == correctAnswer)
            System.out.println("correct answer");
        else
            System.out.println("Wrong answer "+ maxProfit +", correct one is "+correctAnswer);

    }


    static int ksRec(int[] profits, int[] weights, int target, int itemCount) {
        if(target == 0 || itemCount == 0)
            return 0;
        if(weights[itemCount-1] > target) // current item's weight is more than the capacity
            return  ksRec(profits, weights, target, itemCount-1); // skip the current item
        else {
            // try including and not including the current item
            int profitIfIncluded = profits[itemCount-1] + ksRec(profits, weights, target-weights[itemCount-1], itemCount-1);

            int profitIfNotIncluded = ksRec(profits, weights, target, itemCount-1);

            return Math.max(profitIfIncluded, profitIfNotIncluded);
        }
    }

    private static int knapsackMax(int[] weight, int[] cost, int W) {
        return rec(weight, cost, W, weight.length);
    }



    private static int rec(int[] weight, int[] cost, int W, int n) {

        // base condition
        if(n == 0 || W == 0) {
            return 0;
        }


        if(memo[W][n-1] != 0) return memo[W][n-1];

        if(weight[n-1] > W) {
            int profit =  cost[n-1] + rec(weight, cost, W, n-1);
            memo[W][n-1] = profit;
            return profit;
        }
        else {
            int profit1 = cost[n-1] + rec(weight, cost, W-weight[n-1], n-1);
            int profit2 = rec(weight, cost, W, n-1);
            memo[W][n-1] = Math.max(profit1, profit2);
            return memo[W][n-1];
        }
    }

    private static int topDown(int[] weight, int[] cost, int W, int n) {
        // prefill the base conditions
        for(int i = 0, j=0; i<=n && j <= W; i++, j++) {
            if( i == 0 || j == 0)
                t[i][j]=0;
        }

        // iteratively start finding the profit from the capacity to 1 to W
        // reuse the computed value from previous cells
        for(int i=1;i<=n;i++) { // for each element
            for(int j=1;j<=W;j++) {// at each capacity starting from 1 unit all the way till W
                // check if we can fit this item in sack
                if(weight[i-1] > j) // we are not comparing it with W, please note.
                    t[i][j] = t[i-1][j]; // copy the profit for same weight that we made using the prev element
                else // we have 2 choices
                    t[i][j] = Math.max(
                            cost[i-1] + t[i-1][j-weight[i-1]], // add current item's value to previously computed value without current weight
                            t[i-1][j] // or ignore the current one, and just consider the prev savings
                    );
            }
        }
        return t[n][W]; // loop breaks at the value of n & w. in that row & column there will be our ans.
    }
}
