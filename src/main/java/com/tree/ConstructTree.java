package com.tree;

import java.util.HashMap;
import java.util.Map;

class TN {
    public TN(int val) {
        this.val = val;
    }
    int val;
    TN left;
    TN right;
}
public class ConstructTree {

    static Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
    static int postOrderRearIndex;

    public static void main(String[] args) {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder =   {9, 3, 15, 20, 7};

        // post order will give the roots
        // in order will give the left and right parts
        // running inorder index, from rear to font
        // a map to get the index from value => inorder array

        postOrderRearIndex = postorder.length-1;
        for(int i=0;i<inorder.length;i++) inOrderIndexMap.put(inorder[i], i);

        TN head =  solve(postorder, 0, postorder.length-1);

        printTree(head);
    }

    static void printTree(TN root) {
        if(root == null) return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    private static TN solve(int[] postorder, int left, int right) {
        if(left > right)
            return null;

        int rootVal = postorder[postOrderRearIndex--];
        TN node = new TN(rootVal);

        node.left = solve(postorder, left, inOrderIndexMap.get(rootVal)-1);
        node.left = solve(postorder, inOrderIndexMap.get(rootVal)+1, right);

        return node;
    }
}
