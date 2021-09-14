package com.dp;

import java.util.*;
public class BestConstruct {
    List<List<String>> allPossibilities = null;

    /**
     * Given a target word and collection of words, find the optimal way to construct the word using minimal words
     * */

    List<String> bestWay(String target, String[] wordBank) {
        if(target.isEmpty())
            return new ArrayList<>();

        List<String> bestSoFar = null;
        for(String word: wordBank) {
            if(target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<String> currentChoice = bestWay(suffix, wordBank);
                if(currentChoice == null)
                    continue;
                List<String> list = new ArrayList<>();
                list.add(word);
                list.addAll(currentChoice);
                if(bestSoFar == null || list.size() < bestSoFar.size())
                    bestSoFar = list;
            }
        }
        return bestSoFar;
    }
    List<String> allWays(String target, String[] wordBank) {
        if(target.isEmpty())
            return new ArrayList<>();

        for(String word: wordBank) {
            if(target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<String> combi = allWays(suffix, wordBank);
                if(combi == null)
                    continue;
                List<String> list = new ArrayList<>();
                list.add(word);
                list.addAll(combi);
                allPossibilities.add(list);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BestConstruct obj = new BestConstruct();
//        obj.allWays("vishal", new String[]{"vish", "al", "v", "i", "shal", "vis", "hal", "ha", "l"});
//        if(allPossibilities.isEmpty())
//            System.out.println("Impossible");
//        else {
//            allPossibilities.forEach(System.out::println);
//        }
        obj.allPossibilities = new ArrayList<>();
        List<String> bestWay = obj.bestWay("vishal", new String[]{"vish","al","vishal"});
        if(bestWay == null)
            System.out.println("Impossible");
        else
            System.out.println(bestWay);

    }
}
