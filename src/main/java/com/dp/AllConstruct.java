package com.dp;
import com.google.common.collect.Lists;

import java.util.*;
public class AllConstruct {
    static Map<String, List<List<String>>> memo = new HashMap<>();
    static String[] wordBank = {"e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeeeeee"};
    public static void main(String[] args) {
        String target = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        AllConstruct allConstruct = new AllConstruct();
        List<List<String>> lists = allConstruct.allWays(target);
        if(null == lists || lists.isEmpty())
            System.out.println("Impossible");
        else
            System.out.println(lists);
    }
    List<List<String>> allWays(String target) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<String>> result = null;
        for(String word: wordBank) {
            if(target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allWays(suffix);
                if(suffixWays == null)
                    continue;
                if(suffixWays.size() == 0) {
                    if(result == null) result = new ArrayList<>();
                    result.add(Lists.newArrayList(word));
                }
                else {
                    if(result == null) result = new ArrayList<>();
                    suffixWays.forEach(way -> way.add(0,word));
                    result.addAll(suffixWays);
                }
            }
        }
        memo.put(target, result);
        return result;
    }
}
