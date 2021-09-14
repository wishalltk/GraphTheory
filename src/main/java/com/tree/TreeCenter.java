package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeCenter {
    public static List<List<Integer>> createEmptyTree(int n) {
        List<List<Integer>> tree = new ArrayList<>(n);
        for (int i = 0; i < n; i++) tree.add(new LinkedList<>());
        return tree;
    }

    public static void addUndirectedEdge(List<List<Integer>> tree, int from, int to) {
        tree.get(from).add(to);
        tree.get(to).add(from);
    }
    public static void main(String[] args) {
        List<List<Integer>> graph = createEmptyTree(9);
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 2, 1);
        addUndirectedEdge(graph, 2, 3);
        addUndirectedEdge(graph, 3, 4);
        addUndirectedEdge(graph, 5, 3);
        addUndirectedEdge(graph, 2, 6);
        addUndirectedEdge(graph, 6, 7);
        addUndirectedEdge(graph, 6, 8);

        System.out.println(new TreeCenter().treeCenter(graph));
    }

    List<Integer> treeCenter(List<List<Integer>> tree) {
        // get the total node count
        int totalNodeCount = tree.size();

        //populate 2 arrays. 1) for maintaining degree 2) for keeping the leaves
        int[] degrees = new int[totalNodeCount];
        List<Integer> leaves = new ArrayList<>(totalNodeCount);

        //iterate over all nodes, identify the leaf nodes, append them to leaves and update the degrees
        for(int i=0;i<totalNodeCount;i++) {
            List<Integer> neighbours = tree.get(i);
            degrees[i]=neighbours.size();
            if(degrees[i]<=1) {
                leaves.add(i);
                degrees[i]=0;
            }
        }

        int processedLeafCount = leaves.size();
        //run a while loop until the processed leaf count matches the total node count
        //for each leaf node, get their neighbours
        //reduce their degree by 1 since we have removed one  of their leaf nodes.
        //if the reduced degree is 1, add the neighbor to the new leaf list
        //once the neighbors are processes, update the degree of main node as 0
        //by the end of while loop update the processed leaf count and  replace the  old leaf list with new one
        while (processedLeafCount<totalNodeCount) {
            List<Integer> newLeaves = new ArrayList<>();
            for(int oldLeaf: leaves) {
                for(int neighbor: tree.get(oldLeaf)) {
                    degrees[neighbor] -= 1;
                    if(degrees[neighbor] == 1) {
                        newLeaves.add(neighbor);
                    }
                }
                degrees[oldLeaf]=0;
            }
            processedLeafCount += newLeaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }
}
