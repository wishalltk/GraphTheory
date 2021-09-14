package com.map;

import java.util.*;

public class AnagramSolver {
    public static void main(String[] args) {
        String one = "dormitory";
        String two = "dirtyroam";

        boolean areAnagram = checkIfAnagram(one, two);
        System.out.println(areAnagram);
    }

    private static boolean checkIfAnagram(String one, String two) {

        if (null == one || null == two || one.length() != two.length())
            return false;

        //boolean isAnagram = true;

        Map<Character, Integer> oneMap = new HashMap<>();
       // Map<Character, Integer> twoMap = new HashMap<>();

        for (int i = 0; i < one.length(); i++) {
            char oneChar = one.charAt(i);
            char twoChar = two.charAt(i);

            oneMap.merge(oneChar, 1, Integer::sum);

            Integer count2 = oneMap.get(twoChar);
            if(count2 == null)
                oneMap.put(twoChar, -1);
            else
                oneMap.put(twoChar, --count2);

            if(oneMap.get(oneChar) != null && oneMap.get(oneChar).equals(0))
                oneMap.remove(oneChar);
            if(oneMap.get(twoChar) != null && oneMap.get(twoChar).equals(0))
                oneMap.remove(twoChar);

        }



//        for(int i=0;i<two.length();i++) {
//            char oneChar=one.charAt(i);
//            if(oneMap.containsKey(oneChar)) {
//                Integer count = oneMap.get(oneChar);
//                if(count == null) {
//                    return false;
//                } else {
//                    if(count.equals(1))
//                        oneMap.remove(oneChar);
//                    else
//                        oneMap.put(oneChar, --count);
//                }
//            }
//        }

//        for(Map.Entry<Character, Integer> entry: oneMap.entrySet()) {
//            Character key = entry.getKey();
//            Integer count = entry.getValue();
//            if(null == twoMap.get(key) || !count.equals(twoMap.get(key))) {
//                isAnagram = false;
//                break;
//            }
//
//        }

        return oneMap.isEmpty();
    }
}
