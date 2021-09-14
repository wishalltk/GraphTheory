package com.trie;
import java.util.*;
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] words = {"vishal", "vishaa", "vishak"};
        TrieNode head = new TrieNode();
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        for(String word : words)
            longestCommonPrefix.insertIntoTrie(word, head);
        System.out.println("longest prefix is "+longestCommonPrefix.findLongestPrefix(head));
    }

    String findLongestPrefix(TrieNode head) {
        if(null == head) return null;
        TrieNode cur = head;
        StringBuilder builder = new StringBuilder();
        while (!cur.isLeaf && cur.characters.size() == 1){
            for(Map.Entry<Character, TrieNode> entry : cur.characters.entrySet()) {
                builder.append(entry.getKey());
                cur = entry.getValue();
            }
        }
        return builder.toString();
    }

    void insertIntoTrie(String word, TrieNode head) {
        if(null == head || null == word) return;
        TrieNode cur = head;
        for(char c : word.toCharArray()) {
            cur.characters.putIfAbsent(c, new TrieNode());
            cur = cur.characters.get(c);
        }
        cur.isLeaf = true;
    }
}

class TrieNode {
    Map<Character, TrieNode> characters = new HashMap<>();
    boolean isLeaf = false;
}
