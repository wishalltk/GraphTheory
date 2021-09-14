package com.heap;

import java.util.*;

public class MedianFinder {

    Queue<Integer> maxQueue;
    Queue<Integer> minQueue;

    public MedianFinder() {
        maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        minQueue = new PriorityQueue<>();
    }

    public static void main(String[] args) {
        int[] a = {5,3,4,2,6,1};
        MedianFinder medianFinder = new MedianFinder();
        for(int n : a)
            medianFinder.addNum(n);

    }

    public void addNum(int num) {

        if(maxQueue.isEmpty() || maxQueue.peek() > num)
            maxQueue.add(num);
        else
            minQueue.add(num);
        if(maxQueue.size() > minQueue.size()+1) {
            int diff = maxQueue.size() - (minQueue.size()+1);
            while (diff-- > 0){
                minQueue.add(maxQueue.poll());
            }
        } else if(minQueue.size() > maxQueue.size()+1) {
            int diff = minQueue.size() - (maxQueue.size()+1);
            while (diff-- > 0)
                maxQueue.add(minQueue.poll());
        }

    }

    public double findMedian() {
        double answer;
        int maxQSize = maxQueue.size();
        int minQSize = minQueue.size();
        if(maxQSize > minQSize)
            answer = maxQueue.peek();
        else if(maxQSize < minQSize)
            answer = minQueue.peek();
        else
            answer = (maxQSize>0) ? (maxQueue.peek()+minQueue.peek())/2.0 : 0.0;
        return answer;
    }
}
