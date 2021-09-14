package com.arraybased;

public class Kadane {
    public static void main(String[] args) {
        int[] a = {-15 , -24 , -2 , 6 , -1};
        kadane(a);
    }

    static void kadane(int[] a) {
        int localSum = 0;
        int globalSum = Integer.MIN_VALUE;

        for (int j : a) {
            localSum += j;
            if (localSum < 0)
                localSum = 0;
            else
                globalSum = Math.max(localSum, globalSum);

        }
        System.out.println(globalSum);
    }
}
