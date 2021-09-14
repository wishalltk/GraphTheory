package com.arraybased;

import java.util.Arrays;

public class RemoveDupInSortedArray {
    public static void main(String[] args) {

        int[] a = {1,4,4,4,4,5,6,6};
        int sp = 0;
        int fp = 1;
        int count = 1;

        // while fp < length
        // if sp == fp
                // if fp == length-1
                // return
                // else
                // fp ++
        // else
                //if(fp-sp > 1)
                        // swap(a, sp+1, fp)
                        // fp ++

        while (fp < a.length) {
            if(a[sp] == a[fp]) {
                if(fp == a.length-1)
                    break;
                else
                    fp++;
            } else {
                // sp != fp
                if(fp-sp > 1) {
                    count++;
                    swap(a, sp+1, fp);
                } else {
                    count++;
                }

                sp++;fp++;

            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println(count);
    }

    private static void swap(int[] a, int op1, int op2) {
        int tmp = a[op1];
        a[op1] = a[op2];
        a[op2] = tmp;
    }
}
