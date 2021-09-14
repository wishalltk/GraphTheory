package com.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Traversals {
    public static void main(String[] args) {
//        Node node = TreeUtil.getTreeA();
//        Node node1 = node;
//        Node node2 = node;
//        System.out.print("In order => ");
//        printInOrder(node);
//        System.out.println();
//        System.out.print("Pre order => ");
//        printPreOrder(node1);
//        System.out.print("\nPost order => ");
//        printPostOrder(node2);
        final 
        int[] arr = {1,2,3,5,8};
        int i = Arrays.binarySearch(arr, 6);
        System.out.println(i);

    }

    static void printPostOrder(Node node) {
        if(node == null) return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value+"\t");
    }

    static void printInOrder(Node node) {
        if(node == null) return;

        printInOrder(node.left);
        System.out.print(node.value+"\t");
        printInOrder(node.right);
    }

    static void printPreOrder(Node node) {
        if(node == null) return;

        System.out.print(node.value+"\t");
        printInOrder(node.left);
        printInOrder(node.right);
    }
}
