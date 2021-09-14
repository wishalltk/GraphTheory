package com.map;

public class StringTest {
    public static void main(String[] args) {
        String s = "vishal";
        //          012345
        String ss = s.substring(0, 5);
        String tail = s.substring(5);
        System.out.println(ss+"~"+tail);
    }
}
