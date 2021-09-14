package com.map;
import java.util.*;
public class PalindromePairs {

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> lists = new PalindromePairs().palindromePairs(words);
        System.out.println(lists);
    }

    private List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> answers = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>(words.length);

        for(int i=0;i< words.length;i++) {
            map.put(words[i], i);
        }

        //check reverse string exists
        for(int i=0;i<words.length;i++) {
            String rev = reverse(words[i]);
            Integer idx = map.get(rev);
            if(idx != null && !idx.equals(i))
                answers.add(makeList(i, idx));
        }

        //check for empty strings
        if(map.containsKey("")){
            int idx = map.get("");
            for(int i=0;i< words.length;i++) {
                if(i == idx) continue;
                answers.add(makeList(i, idx));
                answers.add(makeList(idx, i));
            }
        }

        //reverse of prefix available and rest of the string is pal
        for(int i=0;i<words.length;i++){
            String cur_string = words[i];
            for(int j=1;j<cur_string.length()-2;j++) {
                String prefix = cur_string.substring(0, j);
                String suffix = cur_string.substring(j);
                String revPrefix = reverse(prefix);
                if(map.containsKey(revPrefix) && isPal(suffix)) {
                    int idx = map.get(revPrefix);
                    if(idx != i)
                        answers.add(makeList(i, idx));
                }
            }
        }

        //reverse of suffix exists and rest is pal
        for(int i=0;i< words.length;i++) {
            String cur = words[i];
            for(int j=cur.length()-1;j>0;j--){
                String prefix = cur.substring(0, j);
                String suffix = cur.substring(j);
                String revSuffix = reverse(suffix);
                if(map.containsKey(revSuffix) && isPal(prefix)){
                    int idx = map.get(revSuffix);
                    if(idx != i)
                        answers.add(makeList(i, idx));
                }
            }
        }


        return answers;
    }

    private boolean isPal(String s) {
        int i=0;
        int j=s.length()-1;
        while (i<=j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }

    private String reverse(String a) {
        return new StringBuilder(a).reverse().toString();
    }

    private List<Integer> makeList(int a, int b){
        List<Integer> list = new ArrayList<>(2);
        list.add(a);
        list.add(b);
        return list;
    }
}
