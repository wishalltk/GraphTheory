package com.heap;
import java.util.*;
public class TopKFrequentUsingMap {
    static Map<Integer, Integer> map = new HashMap<>();
    static PriorityQueue<Element> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.freq));
    static int k;
    public static void main(String[] args) {
            int[] input = {1,2,3,1,2,4,1,2,5};
            k = 2;
            for(int i : input)
                addToMap(i);
        System.out.println("Top "+k+" frequent numbers are");
        printTopK();
    }

    private static void printTopK() {
        List<Element> temp = new ArrayList<>(k);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new Element(entry.getKey(), entry.getValue()));
            if(queue.size() > k)
                queue.poll();
        }
        for(int i=0;i<k;i++)
            temp.add(queue.poll());
        temp.sort((e1, e2) -> e2.freq - e1.freq);
        temp.forEach(System.out::println);
        queue.addAll(temp);

    }

    private static void addToMap(int i) {
        map.merge(i, 1, Integer::sum);
    }
}

 class Element {
    int value;
    int freq;

     @Override
     public String toString() {
         return "Element{" +
                 "value=" + value +
                 ", freq=" + freq +
                 '}';
     }

     public Element(int value, int freq) {
         this.value = value;
         this.freq = freq;
     }
 }