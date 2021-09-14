package com.recursion;

public class ReverseString {
    public static void main(String[] args) {
        String s = "hello dear world";
//        System.out.println(s.substring(0, 1));
//        System.out.println(s.substring(1));
        String rev = reverse(s);
        System.out.println(reverse(rev));
    }

    private static String reverse(String s) {
        if(s.length() == 1)
            return s;
        String prefix = s.substring(0,1);
        String remain = s.substring(1);
        return reverse(remain)+prefix;
    }
}
