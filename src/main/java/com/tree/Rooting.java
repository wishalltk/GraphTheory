package com.tree;

import java.util.ArrayList;
import java.util.List;

public class Rooting {

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>(7);
        int rootId = 2;
        TreeNode rootNode = new TreeNode(rootId);
        TreeNode rooted = recursiveRooting(graph, rootNode);
    }

    private static TreeNode recursiveRooting(List<List<Integer>> graph, TreeNode node) {
        for (Integer childId : graph.get(node.id)) {
            if (node.parent == null || node.parent.id == childId)
                continue;
            TreeNode childNode = new TreeNode(childId);
            childNode.parent = node;

            recursiveRooting(graph, childNode);
        }
        return node;
    }


}
