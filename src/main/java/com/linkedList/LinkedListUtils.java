package com.linkedList;

public class LinkedListUtils {
    static void print(Node root) {
        Node node = root;
        while (node != null) {
            System.out.print(node.val+" --> ");
            node = node.next;
        }
        System.out.println( "NULL" );
    }
}
