package com.graph;
import java.util.*;
public class TopSortChars {
    static Map<Character, List<ZEdge<Character>>> adjList;
    static boolean[] visited = null;
    public static void main(String[] args) {
        char[][] courses = {{'a','b'}, {'a','c'},{'b','d'},{'c','d'}};
        int n = 4;
        visited = new boolean[n];
        adjList = new HashMap<>();
        for(char[] course: courses) {
            char from = course[0];
            char to = course[1];
            adjList.putIfAbsent(from, new ArrayList<>());
            adjList.get(from).add(new ZEdge<>(from, to));
        }

        List<Character> answer = new ArrayList<>();
        char[] nodes = {'b','a','d','c'};

  



    }
}
