package com.graph;
import java.util.*;
public class TopologicalSort {
    static boolean[] visited = null;
    static Map<Integer, List<Edge>> adjMap = null;
    static int[] answer = null;
    public static void main(String[] args) {
        int[][] arr = {{0, 1},{0, 2},{1, 3},{2, 3}};
        int n = 4;
        answer = new int[4];
        adjMap = new HashMap<>();
        visited = new boolean[n];
        for(int[] pair: arr) {
            int from = pair[0];
            int to = pair[1];
            adjMap.putIfAbsent(from, new ArrayList<>());
            adjMap.get(from).add(new Edge(from, to));
        }
        int ansIndex = 0;
        for(int node=0;node<n;node++) {
            if(!visited[node]) {
              //  dfs(node);
            }

        }

    }
}
