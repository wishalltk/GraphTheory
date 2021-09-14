package com.tree;

public class MaxHeight {
    public static void main(String[] args) {
        Node root = TreeUtil.getTreeA();

        int height = new MaxHeight().height(root);
        System.out.println("height is "+height);
    }

    int height(Node node) {
        return (node == null)?-1:Math.max(height(node.left), height(node.right)) + 1;
    }
}
