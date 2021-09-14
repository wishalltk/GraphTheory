package com.tree;

public class LeafNodeSum {

    static Node root;

    public static void main(String[] args) {

        root = TreeUtil.getTreeA();

        int sum = new LeafNodeSum().leafSum(root);
        System.out.println("sum is "+sum);

    }

    int leafSum(Node node) {

        if(node == null)
            return 0;

        if(node.size() == 0)
            return node.value;

        return leafSum(node.left) + leafSum(node.right);
    }

}
