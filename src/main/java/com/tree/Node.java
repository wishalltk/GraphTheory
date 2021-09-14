package com.tree;

public class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
    }

    int size(){
        int size = 0;
        if(null != left) size++;
        if(null != right) size++;
        return size;
    }
}
