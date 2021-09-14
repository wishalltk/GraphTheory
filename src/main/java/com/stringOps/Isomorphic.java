package com.stringOps;

import java.util.*;

public class Isomorphic {
    public static void main(String[] args) {
        String s1 = "egge";
        String s2 = "oddo";
        boolean areIsomorphic = checkIfIsomorphic(s1, s2);
        System.out.println(areIsomorphic);
    }

    private static boolean checkIfIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        char[] ca1 = s1.toCharArray();
        char[] ca2 = s2.toCharArray();
        for (int i = 0; i < ca1.length; i++) {
            Character c1 = ca1[i];
            Character c2 = ca2[i];
            Character ct = map.get(c1);
            if (ct == null) {
                if(used.contains(c2))
                    return false;
                map.put(c1, c2);
                used.add(c2);
            } else {
                if (ct != c2)
                    return false;
            }
        }
        return true;
    }

}
