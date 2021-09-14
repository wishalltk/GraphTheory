package com.heap;

import java.util.*;
public class TopKFrequent {

    static Map<Integer, Integer> map = new HashMap<>();
    static Queue<Pojo1> queue = new PriorityQueue<>(Comparator.comparingInt(pojo -> pojo.freq));
    static int k;
    public static void main(String[] args) {
        int[] a  = {1,2,3,1,2,4,1,2,5};
        k = 2;
        for(int i : a)
            addToHeap(i);
        System.out.println("Printing top "+k+" elements");
        printTopK();
    }

    private static void printTopK() {
        queue.forEach(System.out::println);
    }

    private static void addToHeap(int num) {
        map.merge(num, 1, Integer::sum);
        int curFreq = map.get(num);
        if(queue.size() < k)
            queue.offer(new Pojo1(num, curFreq));
        else {
            int top = queue.size()==0 ? Integer.MIN_VALUE : queue.peek().freq;
            if(curFreq > top) {
                queue.poll();
                queue.offer(new Pojo1(num, curFreq));
            }
        }
    }
}


class Pojo1 {

    public Pojo1(int number, int freq) {
        this.number = number;
        this.freq = freq;
    }

    int number;
    int freq;

    @Override
    public String toString() {
        return "{" +
                "number=" + number +
                ", freq=" + freq +
                '}';
    }
}