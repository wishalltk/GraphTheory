package com.graph;
import java.util.*;
public class UnionFind {
    static int[] size;
    static int[] ids = null;
    public static void main(String[] args) {
        int[][] edgePairs = { {0,1},{1,2},{3,4}};
        int n = edgePairs.length + edgePairs[0].length;
        size = new int[n];
        Arrays.fill(size, 1);
        int numOfConnectedComponents = getConnectedComponents(edgePairs, n);
        System.out.println(numOfConnectedComponents);
        System.out.println("Union mapping -> "+Arrays.toString(ids));
        System.out.println("Size mapping -> "+Arrays.toString(size));
    }

    private static int getConnectedComponents(int[][] edgePairs, int numOfNodes) {
        ids = new int[numOfNodes];
        for(int i=0;i<numOfNodes;i++)
            ids[i]=i;

        for(int[] pair : edgePairs)
            doUnion(ids, pair[0], pair[1]);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<ids.length;i++) {
            int tmp = findParent(ids, i);
            set.add(tmp);
        }

        return set.size();
    }

    private static void doUnion(int[] ids, int vertex1, int vertex2) {
        int parent1 = findParent(ids, vertex1);
        int parent2 = findParent(ids, vertex2);
        if(size[parent1] > size[parent2]) {
            ids[parent1] = parent2;
            size[parent1] += size[parent2];
            size[parent2] = 0;
        }else {
            ids[parent2] = parent1;
            size[parent2] += size[parent1];
            size[parent1] = 0;
        }
    }

    private static int findParent(int[] ids, int child) {
        int root = child;
        while (child != ids[child]) {
            child = ids[child];
        }
        // Path compression
        while (root != ids[root]) {
            int tmp = ids[root];
            ids[root] = child;
            root = tmp;
        }
        return child;
    }


}
