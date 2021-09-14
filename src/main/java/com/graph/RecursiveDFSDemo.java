package com.graph;
import com.google.common.collect.Lists;

import java.util.*;
public class RecursiveDFSDemo {
    public static void main(String[] args) {
        Edge e1 = new Edge(10, 20);
        Edge e2 = new Edge(10, 2);
        Edge e3 = new Edge(2, 3);
        Edge e4 = new Edge(2, 4);

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        List<Integer> list1  = Lists.newArrayList(2, 20);
        adjList.put(10, list1);
        List<Integer> list2  = Lists.newArrayList(3, 4);
        adjList.put(2, list2);

        bfsIterative(10,adjList, new ArrayList<>());

    }


    private static void bfsIterative(Integer node, Map<Integer, List<Integer>> adjList, List<Integer> visited) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.toString();
        int[] a = new int[6];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(node);
        int qSize = queue.size();
        int level=1;
        while (!queue.isEmpty()) {
            System.out.println("\nPrinting level "+ level++);
            for(int i=0;i<qSize;i++) {
                int curNode = queue.removeFirst();
                System.out.print(curNode+"\t");
                visited.add(curNode);
                List<Integer> nextNodes = adjList.get(curNode);
                if(nextNodes == null)
                    continue;
                for(int nextNode : nextNodes) {
                    if(!visited.contains(nextNode)) {
                        queue.addLast(nextNode);
                    }
                }
            }
            qSize = queue.size();
        }

    }

    private static void dfs(Integer node, Map<Integer, List<Integer>> adjList, List<Integer> visited) {
        // this will never hit a null
//        if(node == null)
//            return;
        // mark the node as visited
        System.out.print(node+"\t");
        visited.add(node);

        //check if there are any outgoing nodes
        List<Integer> nextNodes = adjList.get(node);
        if(null == nextNodes) {
            System.out.println("reached leaf node");
            return;
        }

        //get all the outgoing nodes
        for(Integer nextNode :  nextNodes) {
            if(!visited.contains(nextNode))
                dfs(nextNode, adjList, visited);
        }

    }
}
