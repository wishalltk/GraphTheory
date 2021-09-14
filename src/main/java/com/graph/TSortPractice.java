package com.graph;



import java.util.*;

public class TSortPractice {

    static class EdgeV2 {
        String to;
        String from;

        public EdgeV2(String from, String to) {
            this.to = to;
            this.from = from;
        }
    }
    static int n = 5;
    static Map<String, List<EdgeV2>> graph;
    static String ordering = " ";
    static Set<String> visitRegister;
    public static void main(String[] args) {
        graph = new HashMap<>(n);
        visitRegister = new HashSet<>(n);
        /*graph.put("a", Lists.newArrayList(new EdgeV2("a", "b"), new EdgeV2("a", "c")));
        graph.put("b", Lists.newArrayList(new EdgeV2("b", "d")));
        graph.put("c", Lists.newArrayList(new EdgeV2("c", "d")));
        graph.put("d", Lists.newArrayList(new EdgeV2("d", "e")));*/

        topSort();
        System.out.println(ordering);
    }

    static boolean notVisited(String node){
        return !visitRegister.contains(node);
    }

    static void doVisit(String node) {
        visitRegister.add(node);
    }

    static void dfs(String currentNode) {
        doVisit(currentNode);
        if(graph.containsKey(currentNode)) {
            for(EdgeV2 edgeV2: graph.get(currentNode)) {
                String nextNode = edgeV2.to;
                if(notVisited(nextNode))
                    dfs(nextNode);
            }
        }
        ordering = currentNode+" "+ordering;
    }

    static void topSort() {
        Set<String> nodes = graph.keySet();
        for(String node: nodes) {
            if(notVisited(node))
                dfs(node);
        }

        System.out.println("top sort done");
    }
}
