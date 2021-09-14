package com.dp;

public class Permutation {
    public static void main(String[] args) {
        String string = "ab";
        Permutation permutation = new Permutation();
        permutation.permute("", string);
    }

    String permute(String head, String tail) {
        // f(a, bc)
        // f(b, ac)
        // f(c, ab)
        int n = tail.length();
        String result = "";
        for (int i = 0; i < n; i++) {
           result += permute(head+tail.charAt(i), tail.substring(0,i)+tail.substring(i+1,(n-i)));
        }
        return result;
    }
}
