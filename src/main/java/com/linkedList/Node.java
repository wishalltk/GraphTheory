package com.linkedList;

public class Node {

    public Node(final int val) {
        this.val = val;
    }

    final int val;
    Node next;
    Node prev;

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrev() {
        return prev != null;
    }

    @Override
    public String toString() {
        return val+" --> ";
    }
}
