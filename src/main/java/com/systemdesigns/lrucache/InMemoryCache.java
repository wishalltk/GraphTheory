package com.systemdesigns.lrucache;

import java.util.*;

class LRUNode {
    public LRUNode(String data) {
        this.data = data;
    }

    LRUNode next;
    LRUNode prev;
    String data;
}

public class InMemoryCache {
    private final int CACHE_SIZE;
    private final LinkedList<LRUNode> lruList;
    private final Map<Integer, LRUNode> map;
    private final LRUNode head;
    private final LRUNode tail;
    private int currentSize = 0;

    public InMemoryCache(final int cacheSize) {
        map = new HashMap<>();
        CACHE_SIZE = cacheSize;
        lruList = new LinkedList<>();
        head = new LRUNode("head");
        tail = new LRUNode("tail");
        head.next = tail;
        tail.prev = head;
    }

    String get(Integer key) {
        LRUNode node = map.get(key);
        if (node == null)
            return null;
        String  data = node.data;
        System.out.println("data retried for key "+key);
        appendAfterHead(node);
        System.out.println("Updated the node reference");
        return data;
    }

    void put(Integer key, String  value) {
        LRUNode newNode = new LRUNode(value);
        insertBeforeTail(newNode, key); 
    }

    private void insertBeforeTail(LRUNode node, int key) {
        LRUNode temp = tail.prev;
        System.out.println("Trying to insert the new node "+temp+" having key = "+key+" & value="+node.data);
        if (currentSize == CACHE_SIZE) {
            temp.prev.next = node;
            node.prev = temp.prev;
            node.next = tail;
           // LRUNode remove = map.remove();
            System.out.println("Cache full .. removing the node "+temp+" having value "+temp.data);
        } else {
            System.out.println("Cache size is withing limits");
            tail.prev = node;
            node.next = tail;
            node.prev = temp;
            temp.next = node;
            currentSize++;
        }
        map.put(key, node);
        System.out.println("Cache insert complete");
    }

    private void appendAfterHead(LRUNode node) {
        LRUNode temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
    }


}
