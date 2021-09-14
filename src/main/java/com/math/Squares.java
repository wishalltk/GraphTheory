package com.math;

import java.util.Arrays;

public class Squares {
    long square(long num) { return num*num;}

    public static void main(String[] args) {
        long[] inputs = {1,2,3,4,5};
        long[] output = new Squares().getSquares(inputs);
        System.out.println(Arrays.toString(output));
    }

    private long[] getSquares(long[] inputs) {
        return Arrays.stream(inputs).map(this::square).toArray();
    }
}
