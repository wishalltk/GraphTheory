package com.dp.revision;

public class Permute {
    public static void main(String[] args) {
        String s = "abc";
        permute(s, 0, s.length()-1);
    }

    static String swap(int a, int b, String s) {
        char[] ca = s.toCharArray();
        char tmp = ca[a];
        ca[a]=ca[b];
        ca[b] = tmp;
        return String.valueOf(ca);
    }

    private static void permute(String string, int start, int end) {
        if(start==end)
            System.out.println(string);
        else {
            for(int i=start; i<end;i++) {

            }
        }
    }
}
