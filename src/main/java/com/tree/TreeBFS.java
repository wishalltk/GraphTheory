package com.tree;

import java.util.*;

public class TreeBFS {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);

        System.out.println("Top View");
       // topView(root);
        int maxLength = maxLen(root);
        System.out.println(maxLength);
    }

    static int maxLen(Node node) {
        if (node == null)
            return 0;
        return Math.max(maxLen(node.left), maxLen(node.right))+1;

//        int leftMax = maxLen(node.left);
//        int rightMax = maxLen(node.right);
//        return Math.max(leftMax, rightMax)+1;
    }

    static void topView(Node root) {
        if (null == root) return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tmp = queue.peek();
                if (i == 0 || i == size - 1)
                    System.out.print(tmp.value + "\t");
                queue.poll();
                if (null != tmp.left) queue.add(tmp.left);
                if (null != tmp.right) queue.add(tmp.right);
            } //for
            System.out.println();
        }

    }//topview


    private static void spiral(Node root) {
        if (null == root) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (queue.size() > 0) {
            int qSize = queue.size();
            System.out.print("level " + level + "=> \t\t");
            if (level % 2 == 1) {
                // reverse way
                for (int i = 1; i <= qSize; i++) {
                    Node tmp = queue.poll();
                    System.out.print(tmp.value + "\t");
                    if (null != tmp.left) queue.add(tmp.left);
                    if (null != tmp.right) queue.add(tmp.right);
                }
            } else {
                // forward way
                List<Node> list = new ArrayList<>(queue);
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i).value + "\t");
                    Node tmp = queue.poll();
                    if (null != tmp.left) queue.add(tmp.left);
                    if (null != tmp.right) queue.add(tmp.right);
                }
            }

            System.out.println();
            level++;
        }

    }

    private static void doBFS(Node root) {
        if (null == root) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int view = 2; // 1 left; 2 right
        while (queue.size() > 0) {
            int queueSize = queue.size();
            boolean printed = false;
            while (queueSize-- > 0) {
                Node tmp = queue.peek();
                if (view == 1) {
                    if (!printed) {
                        System.out.println(tmp.value);
                        printed = true;
                    }
                } else {
                    if (queueSize == 0)
                        System.out.println(tmp.value);
                }
                queue.poll();
                // System.out.print(tmp.value+"\t");
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            // System.out.println("Level Completed");
        }


    }
}
