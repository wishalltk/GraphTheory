package com.machinecoding;

import java.util.LinkedList;
import java.util.Queue;

public class KProduct {
    private final int K;
    private Integer product = null;
    private Integer runningProduct = null;
    private Queue<Integer> queue = new LinkedList<>();
    private int zeroIn = 0;
    private int zeroOut = 0;

    public KProduct(int k) {
        K = k;
    }

    /**
     * 1 1 2 0
     * 1 2 0 2
     * 2 0 2 2
     * 0 2 2 1
     * 2 2 1 3
     */

    private void accept(int number) {
        if (number == 0) {
            zeroIn += 1;
            runningProduct = null;
        }

        if (queue.size() == K & K > 0) {
            int polled = queue.poll();
            if (polled == 0) {
                zeroOut += 1;
            } else {
                if(runningProduct != null && runningProduct == 0)
                    runningProduct /= polled;
            }
        }
        if (number != 0) {
            if (runningProduct == null)
                runningProduct = number;
            else
                runningProduct *= number;
        }
        queue.add(number);
    }

    private int getProduct() {
        if (zeroIn > zeroOut)
            return 0;
        return runningProduct;
    }

    public static void main(String[] args) {
        int k = 4;
        KProduct kProduct = new KProduct(k);
        int[] inputs = {1, 2, 2, 0, 2, 2, 2, 1};
        for (int input : inputs)
            kProduct.accept(input);
        int product = kProduct.getProduct();
        System.out.println(product);

    }


}
