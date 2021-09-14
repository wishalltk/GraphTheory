package com.tree;

import static com.tree.TraverseType.*;

public class TreeDfs {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);

        System.out.println("Doing DFS");
        doDFS(root);

        System.out.println("In Order Traversal");
        traverse(root, IN_ORDER);
        System.out.println("Pre Order Traversal");
        traverse(root, PRE_ORDER);
        System.out.println("Post Order Traversal");
        traverse(root, POST_ORDER);
    }

    private static void traverse(Node root, TraverseType traverseType) {
        if(root == null)
            return;

        switch (traverseType) {
            case IN_ORDER:
                traverse(root.left, IN_ORDER);
                System.out.println(root.value);
                traverse(root.right, IN_ORDER);
                break;

            case PRE_ORDER:
                System.out.println(root.value);
                traverse(root.left, PRE_ORDER);
                traverse(root.right, PRE_ORDER);
                break;

            case POST_ORDER:
                traverse(root.left, POST_ORDER);
                traverse(root.right, POST_ORDER);
                System.out.println(root.value);
        }

    }

    private static void doDFS(Node root) {
        if(root == null)
            return;
        doDFS(root.left);
        System.out.println(root.value);
        doDFS(root.right);

    }
}
