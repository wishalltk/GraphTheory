package com.graph;

import java.util.*;

public class TopSort {

    static boolean[] v;
    static int[] ordering;
    static Map<Integer, List<Edge>> graph;
    public static void main(String[] args) {
        int N = 4;

        v = new boolean[N];
        ordering = new int[N];

        graph = new HashMap<>(N);
        for(int i=0;i<N;i++)
            graph.put(i, new ArrayList<>());

        graph.get(0).add(new Edge(0, 1));
        graph.get(0).add(new Edge(0, 2));
        graph.get(1).add(new Edge(1, 3));
        graph.get(2).add(new Edge(2, 3));
        //graph.get(3).add(new Edge(3, 4));

        topSort(N);
        System.out.println(Arrays.toString(ordering));

    }

    static boolean notVisited(int index) {
        return !(v[index]);
    }

    static void doVisit(int index){
        v[index]=true;
    }

    static void topSort(int totalNodes) {
        int topSortRevIndex = totalNodes - 1;
        for(int currentIndex=totalNodes-1;currentIndex>=0;currentIndex--) {
            if(notVisited(currentIndex))
                topSortRevIndex = dfs(currentIndex, topSortRevIndex);
        }
        System.out.println("top sort finished");
    }

    private static int dfs(int currentNode, int topSortRevIndex) {
        doVisit(currentNode);
        List<Edge> edges = graph.get(currentNode);
        for(Edge edge: edges) {
            int nextNode = edge.to;
            if(notVisited(nextNode))
                topSortRevIndex = dfs(nextNode, topSortRevIndex);
        }
        ordering[topSortRevIndex--]=currentNode;
        return topSortRevIndex;
    }
}
