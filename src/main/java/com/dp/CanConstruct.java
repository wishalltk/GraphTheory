package com.dp;

import java.util.*;

public class CanConstruct {

    private String concat(List<String> strings) {
        StringBuilder builder = new StringBuilder();
        for(String s : strings)
            builder.append(s);
        return builder.toString();
    }

    static Map<String, Boolean> memo = new HashMap<>();


    boolean canConstructBruteForce(String target, String[] allStrings, List<String> soFar) {

        if(memo.containsKey(concat(soFar)))
            return memo.get(concat(soFar));

        if(concat(soFar).equals(target)) {
            return true;
        }
        for(String s: allStrings) {
            int soFarSize = 0;
            for(String i: soFar)
                soFarSize += i.length();
            int remainSize = target.length()-soFarSize;
            if(s.length() <= remainSize) {
                soFar.add(s);
                boolean result = canConstructBruteForce(target, allStrings,soFar);
                if(result) {
                    System.out.println("the answer is "+soFar);
                    break;
                } else
                    soFar.remove(s);
            }

        }
        //System.out.println("no answer found");
        return false;
    }

    static int ways = 0;

    boolean canConstruct(String target, String[] wordBank) {
        if(target.isEmpty())
            return true;
        if(memo.containsKey(target))
            return memo.get(target);
        for(String word: wordBank) {
            if(target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if(canConstruct(suffix, wordBank)) {
                    ways += 1;
                    memo.put(suffix, true);
                }

            }
        }
        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        CanConstruct obj = new CanConstruct();
        long start = System.currentTimeMillis();
        boolean status = obj.canConstruct("vishal", new String[]{"vish","al","v","ishal","vis","hal","ha","l"});
        long end = System.currentTimeMillis();
        System.out.println("Runtime "+(end-start)+" ms");
        if(ways != 0)
            System.out.println("Possible in "+ways+" ways");
        else
            System.out.println("Impossible");


    }
/**
 * vish al
 * v ishal
 * vis hal
 * vis ha l
 * */
}
