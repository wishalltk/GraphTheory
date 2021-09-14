package com.aditya.verma;

public class LCAPractice {
    static boolean v1 = false, v2 = false;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        Node result = findLcaWhenBothMayNotPresent(root, 3, 4);
        //when both nodes are present

        System.out.println(result.value);
    }

    /*
     *      1
     *   2      3
     * 4
     * */

    private static Node findLcaWhenBothPresent(Node cur, int n1, int n2) {
        if (cur == null)
            return null;

        if (cur.value == n1 || cur.value == n2)
            return cur;

        Node leftResult = findLcaWhenBothPresent(cur.left, n1, n2);
        Node rightResult = findLcaWhenBothPresent(cur.right, n1, n2);

        if (leftResult != null && rightResult != null)
            return cur;

        return leftResult != null ? leftResult : rightResult;
    }

    private static Node findLcaWhenBothMayNotPresent(Node cur, int n1, int n2) {
        if (cur == null)
            return null;

        Node tmp = null;

        if (cur.value == n1) {
            v1 = true;
            tmp = cur;
        } else if (cur.value == n2) {
            v2 = true;
            tmp = cur;
        }

        Node left = findLcaWhenBothMayNotPresent(cur.left, n1, n2);
        Node right = findLcaWhenBothMayNotPresent(cur.right, n1, n2);

        if (tmp != null)
            return tmp;

        if (left != null && right != null)
            return cur;

        return left != null ? left : right;
    }
}
/*
 *      1
 *   2      3
 * 4
 * */