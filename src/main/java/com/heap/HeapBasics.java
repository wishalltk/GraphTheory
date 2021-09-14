package com.heap;

import java.util.Arrays;

public class HeapBasics {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6};
//        HeapBasics hb = new HeapBasics();
//        int[] heap = new int[nums.length];
//        for(int num: nums) {
//
//        }
        new HeapBasics().makeMinHeap(nums);
    }

    void makeMinHeap(int[] nums) {
        int[] heap = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            heap[i] = nums[i];
            heapify(heap, i, i);
        }
        System.out.println("heapify done "+ Arrays.toString(heap));
    }

    void maxHeapify(int[] heap, int curIdx) {
        int leftIdx = 2*curIdx+1;
        int rightIdx = 2*curIdx+1;

        int largestIdx = curIdx;
        if(leftIdx <= heap.length && heap[leftIdx] > heap[curIdx])
            largestIdx = leftIdx;
        if(rightIdx <= heap.length && heap[rightIdx] > heap[largestIdx])
            largestIdx = rightIdx;
        if(largestIdx != curIdx) {
            swap(heap, largestIdx, curIdx);
            maxHeapify(heap, largestIdx);
        }
    }

    int heapify(int[] nums, int currentNodeIndex, int length) {

        int leftChildIndex = (2*currentNodeIndex)+1;
        int rightChildIndex = (2*currentNodeIndex)+2;

        // breaking conditions - start
        // Check if we have reached the leaf nodes already.
        if(leftChildIndex >= length || rightChildIndex >= length)
            return currentNodeIndex;

        // if current node is larger than both children then return
        if(nums[leftChildIndex] < nums[currentNodeIndex] && nums[rightChildIndex] < nums[currentNodeIndex]) {
            return currentNodeIndex;
        }

        int leftHighestIndex = heapify(nums, leftChildIndex, length);
        int rightHighestIndex = heapify(nums, rightChildIndex, length);

        int largestChildIndex = (nums[leftHighestIndex] > nums[rightHighestIndex]) ? leftHighestIndex : rightHighestIndex;
        if(nums[largestChildIndex] > nums[currentNodeIndex]) {
            swap(nums, largestChildIndex, currentNodeIndex);
        }
        return currentNodeIndex;
    }

    void swap(int[] arr, int op1, int op2) {
        int tmp = arr[op1];
        arr[op1] = arr[op2];
        arr[op2] = tmp;
    }
}
