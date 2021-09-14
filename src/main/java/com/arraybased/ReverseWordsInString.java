package com.arraybased;

import java.util.Arrays;
import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String input = "the sky";
        System.out.println(input+"\n Reversed \n"+reverseWordsOptimal(input));

    }

    static void reverse(char[] a, int start, int end) {
        while (start <= end) {
            char tmp = a[start];
            a[start]=a[end];
            a[end] = tmp;
            start++;end--;
        }
    }

    static String reverseWordsOptimal(String input) {
       return "";
    }

   static String reverseWords(String input) {
        Stack<String> stack = new Stack<>();
        String[] strings = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=strings.length-1;i>=0;i--) {
            sb.append(strings[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
