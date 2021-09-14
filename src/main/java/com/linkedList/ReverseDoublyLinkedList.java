package com.linkedList;

import java.util.Random;

public class ReverseDoublyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        head.prev = null;
        head.next = one;

        one.prev = head;
        one.next = two;

        two.prev = one;
        two.next = three;

        three.prev = two;
        three.next = null;

        //new Random().nextInt(100);

       // System.out.println("LinkedList before reversing");
     //   printDLL(head);
       // System.out.println("\nLinkedList after reversing");
        reverse(head);


    }

    static void printDLL(Node head) {
                System.out.println("printing from right to left");
        while (head != null) {
            System.out.println("current node value = "+head.val);
            System.out.println("Node on its left is "+(head.hasPrev()?head.prev.val:"null"));
            System.out.println("Node on its right is "+(head.hasNext()?head.next.val:"null"));
            head = head.next;
            System.out.println("----------------------");
        }
    }

    static void reverse(Node node) {
        Node prev;
        Node next;
        Node newHead = null;
        while (node != null) {
            prev = node.prev;
            next = node.next;

            node.next = prev;
            node.prev = next;
            newHead = node;
            node = node.prev;
        }
        printDLL(newHead);
    }

}
