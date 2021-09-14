package com.arraybased;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] a = {1, 0, 2, 0, 1};

        nge(a);
    }

    private static void nge(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[a.length];
        stack.push(0);
        for (int i = 1; i < a.length; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                int top = stack.pop();
                nge[top] = a[i];
            }
          stack.push(i);
        }
        while (!stack.isEmpty())
            nge[stack.pop()] = -1;
        System.out.println(Arrays.toString(nge));
    }
}
