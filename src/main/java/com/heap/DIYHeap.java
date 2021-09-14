package com.heap;

import java.util.Arrays;

public class DIYHeap {

    int heapIdx = 0;

    public static void main(String[] args) {
        DIYHeap diyHeap = new DIYHeap();
        int[] heap = new int[7];
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        for (int i : arr) {
            diyHeap.insert(heap, i);
            System.out.println("After inserting " + i + " -> " + Arrays.toString(heap));
        }
        System.out.println(Arrays.toString(heap));
    }

    void insert(int[] heap, int element) {
        heap[heapIdx] = element;
        heapify(heap, heapIdx);
        heapIdx++;
        // iterativeHeapify(heap, heapIdx);
    }

    void iterativeHeapify(int[] heap, int curIdx) {
        while (!hasNoParent(curIdx)) {
            //if () {
            int parentIdx = getParentId(curIdx);
            if (heap[curIdx] <= heap[parentIdx])
                break;
            else {
                swap(heap, curIdx, parentIdx);
                curIdx = parentIdx;
            }
            //  }
        }
    }

    void heapify(int[] heap, int curIdx) {

        if (hasNoParent(curIdx))
            return;

        int parentIdx = getParentId(curIdx);
        if (heap[curIdx] > heap[parentIdx]) {
            swap(heap, curIdx, parentIdx);
            heapify(heap, parentIdx);
        }
    }

    void swap(int[] heap, int idx1, int idx2) {
        int tmp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = tmp;
    }

    int getParentId(int idx) {
        return (idx - 1) / 2;
    }

    boolean hasNoParent(int idx) {
        return getParentId(idx) < 0;
    }


}
