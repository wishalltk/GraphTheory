package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PQTopElements {
    public static void main(String[] args) {
        PQTopElements pqTopElements = new PQTopElements();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<10;i++) {
            minHeap.add(i);
            maxHeap.add(i);
            if(minHeap.size() > 3)
                minHeap.poll();
            if(maxHeap.size() > 3)
                maxHeap.poll();
        }
        System.out.println("Top 3 largest elements are ");
        while (!minHeap.isEmpty())
            System.out.println(minHeap.poll());
        System.out.println("Top 3 smallest elements are ");
        while (!maxHeap.isEmpty())
            System.out.println(maxHeap.poll());
    }

    

}
