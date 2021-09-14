package com.dynamicProgramming;
import java.util.*;
public class F_CanConstruct {

    /*
    * Brute force time:
    * m = target length
    * n = word bank length
    *
    * Time = O(n^m)
    * Space m^2
    * */

    public static void main(String[] args) {
        String[] words = {"e","ee","eeee","eeeee","eeeee","eeeeee"};
        boolean can = canConstruct(words, "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef");
     //   System.out.println("vishal".substring("vish".length()));
        System.out.println(can);
    }

    private static Map<String,Boolean> memo = new HashMap<>();
    private static boolean canConstruct(String[] words, String target) {
        if(memo.containsKey(target)) return memo.get(target);
        if("".equals(target))
            return true;

        for(String word: words) {
            if(target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if(canConstruct(words, suffix)) {
                    //memo.put(suffix, true);
                    return true;
                }

            }
        }
        memo.put(target, false);
        return false;
    }
}
