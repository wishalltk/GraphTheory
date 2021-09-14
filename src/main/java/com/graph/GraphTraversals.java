package com.graph;

import java.util.*;

public class GraphTraversals {
    public static void main(String[] args) {

        //create ds to hold graph data
        Map<Integer, List<EdgeWithWeight>> adjList = new HashMap<>();
        addDirectedEdges(adjList, 0, 1, 1);
        addDirectedEdges(adjList, 0, 2, 3);
        addDirectedEdges(adjList, 1, 2, 1);
        addDirectedEdges(adjList, 1, 3, 5);
        addDirectedEdges(adjList, 2, 4, 2);
        addDirectedEdges(adjList, 3, 5, 1);
        addDirectedEdges(adjList, 4, 3, 1);
        addDirectedEdges(adjList, 4, 5, 5);

        GraphTraversals gt = new GraphTraversals();
        int found = gt.computeDistanceBetweenNodesViaRecursiveDFS(adjList,  1, 5, new boolean[adjList.size()+1]);
        System.out.println(found);
    }

    private static void addDirectedEdges(Map<Integer, List<EdgeWithWeight>> graph, int from, int to, int cost) {
        List<EdgeWithWeight> edgeList = graph.get(from);
        if (edgeList == null) {
            edgeList = new ArrayList<>();
            graph.put(from, edgeList);
        }

        EdgeWithWeight edge = new EdgeWithWeight(from, to, cost);
        edgeList.add(edge);
    }

    /**
     * Counts the number of nodes between start and end nodes. start exclusive, end inclusive
     * */
    private int computeDistanceBetweenNodesViaRecursiveDFS(Map<Integer, List<EdgeWithWeight>> adjList,
                                                           int start,
                                                           int target,
                                                           boolean[] visited) {

        //base condition
        if(start == target)
            return 0;

        //recursive operations
        visited[start]=true;
        List<EdgeWithWeight> nextNodes = adjList.get(start);
        if(nextNodes != null) {
            for(EdgeWithWeight edge: nextNodes) {
                if(!visited[edge.getTo()]) {
                    int dist = computeDistanceBetweenNodesViaRecursiveDFS(adjList, edge.getTo(), target, visited) + 1;
                    System.out.println("returning "+dist);
                    return dist;
                }
            }
        }
        return 0;
    }

    /**
     * check if the given two nodes are connected
     * */
    private boolean checkConnectivityViaRecursiveDFS(Map<Integer, List<EdgeWithWeight>> adjList,
                                                     int start,
                                                     int target,
                                                     boolean[] visited) {
        //breaking condition
        if(target == start)
            return true;

        System.out.println("visiting "+start);
        visited[start]=true;

        List<EdgeWithWeight> nextNodes = adjList.get(start);
        if(nextNodes != null) {
            for(EdgeWithWeight edge : nextNodes) {
                if(!visited[edge.getTo()]) {
                   return checkConnectivityViaRecursiveDFS(adjList, edge.getTo(), target, visited);
                }
            }
        }
        return false;
    }

    /**
     * DFS in recursive way
     * */
    void dfsRecursive(Map<Integer, List<EdgeWithWeight>> adjList, int nodeToVisit, List<Integer> visited) {

        System.out.println("Visiting "+nodeToVisit);
        visited.add(nodeToVisit);

        //base condition
        //when the node has no outgoing edges
        List<EdgeWithWeight> neighborEdges = adjList.get(nodeToVisit);
        if(neighborEdges == null) {
            return;
        }
        // recursive action to perform
        for(EdgeWithWeight edge: neighborEdges) {
            if(!visited.contains(edge.getTo())) {
                // transition between recursive call stacks
                dfsRecursive(adjList, edge.getTo(), visited);
            }
        }
    }

    /**
     * BFS in iterative way
     */
    private int bfsIterative(Map<Integer, List<EdgeWithWeight>> adjList, int startNode) {
        int nodeCount = 0;
        boolean[] visited = new boolean[adjList.size()+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.println("Visiting " + currentNode);
            nodeCount++;
            visited[currentNode] = true;

            List<EdgeWithWeight> currentNodesNeighbors = adjList.get(currentNode);
            if (null == currentNodesNeighbors) {
                System.out.println(currentNode + " has no outgoing edges");
                continue;
            }
            currentNodesNeighbors.stream()
                    .mapToInt(EdgeWithWeight::getTo)
                    .forEach(
                            to -> {
                                if (!visited[to]) {
                                    visited[to] = true;
                                    queue.add(to);
                                }
                            }
                    );
        }
        return nodeCount;
    }

    /**
     * DFS in iterative way. prints every node and returns the count of total nodes
     */
    private int dfsIterative(Map<Integer, List<EdgeWithWeight>> adjList, int startNode) {
        int counter = 0;
        int totalNodes = adjList.size();
        //make a boolean array for tracking visits
        boolean[] visited = new boolean[totalNodes + 1];

        //make an array for tracing path
        int[] path = new int[totalNodes + 1];
        path[0] = -1;

        //create a stack and add the startNode to begin with
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        while (stack.size() > 0) {
            int currentNode = stack.pop();
            System.out.println("Visiting node " + currentNode);

            //mark the node as visited
            visited[currentNode] = true;
            counter++;
            if (adjList.containsKey(currentNode)) {
                for (EdgeWithWeight edgeWithWeights : adjList.get(currentNode)) {
                    if (!visited[edgeWithWeights.getTo()]) {
                        path[edgeWithWeights.getTo()] = currentNode;
                        stack.push(edgeWithWeights.getTo());
                    }
                }
            }
        }
        printPath(path, 5);
        return counter;
    }

    private void printPath(int[] path, int target) {
        String vazhi = "";
        while (true) {
            System.out.println("to " + target + " from " + path[target]);
            vazhi = " -> " + target + vazhi;
            if (path[target] == -1)
                break;
            target = path[target];
        }
        System.out.println(vazhi);
    }


}
