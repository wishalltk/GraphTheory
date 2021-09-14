package com.heap;

import java.util.Arrays;

public class Try1 {

    int[] heap; // this is our heap
    int heapPointer = 0; // this variable holds the position the last inserted element

    public static void main(String[] args) {
        int[] inputData = {1, 2, 3, 4, 5, 6, 7};
        Try1 try1 = new Try1();
        try1.heap = new int[inputData.length];
        for (int input : inputData) {
            System.out.println("Incoming => "+input);
            try1.insertIntoHeap(input);
            System.out.println("After  "+Arrays.toString(try1.heap));
            System.out.println("-----------------------------------");
        }

        /*
         * 2 parts
         * Part 1: create a method that support element insertion into the heap
         * Part 2: once the element is inserted, we need to ensure that the heap property is maintained
         * We need a function which will check the status of the heap after adding the new element and fix the
         * heap structure if required. cool?
         * */
    }

    void insertIntoHeap(int newItem) {
        heap[heapPointer] = newItem;
        System.out.println("Before "+Arrays.toString(heap));
        checkAndFixHeapProperty(heapPointer);
        heapPointer += 1;
    }

    void checkAndFixHeapProperty(int indexOfInsertedElement) { // heapify

        //check if the heap property is distorted?
        // if so, fix the heap
        // if not, do nothing and return

        // 2 ways to write this method 1. iterative 2. recursive way
        while (indexOfInsertedElement > 0) {

            // if heap is in good shape, then exit
            // if the value of parent node is greater than the value of current node, we are good
            int parentIndex = (indexOfInsertedElement - 1) / 2;
            int valueOfParentNode = heap[parentIndex];
            int valueOfCurrentlyInsertedElement = heap[indexOfInsertedElement];

            // checking part
            if (valueOfParentNode >= valueOfCurrentlyInsertedElement)
                break;

            // fixing part
            // swap the parent Node and child node
            heap[parentIndex] = valueOfCurrentlyInsertedElement;
            heap[indexOfInsertedElement] = valueOfParentNode;
            indexOfInsertedElement = parentIndex;
            // kaboom!

        }

    }

}
