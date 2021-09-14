package com.aditya.verma;

public class TreeMaxPathSum {
    public static void main(String[] args) {
        T1 head = new T1(10);
            head.left = new T1(2);
            head.left.left = new T1(3);
            head.left.right = new T1(4);
            head.left.right.right = new T1(2);
            head.left.right.left = new T1(-1);
            head.left.right.left.left = new T1(50);
            head.right = new T1(2);
            head.right.left = new T1(1);
            head.right.right = new T1(1);
            head.right.right.right = new T1(2);

        T1 root = head;
        findMaxSum(head);
        System.out.println(answer);

        System.out.println(longestPath(root, ""));
        System.out.println(maxPath);
    }
    static int answer = Integer.MIN_VALUE;
    private static String maxPath = "";
    private static String longestPath(T1 node, String psf) {

        if(node == null) {
            return psf;
        }

        String leftPath = longestPath(node.left, psf);
        String rightPath = longestPath(node.right, psf);

        maxPath =  node.value+"~"+leftPath+"~"+rightPath;

        return  node.value+"~"+leftPath+"~"+rightPath;

    }

    private static int findMaxSum(T1 currNode) {
        if(currNode == null) return 0;

        int leftSum = findMaxSum(currNode.left);
        int rightSum = findMaxSum(currNode.right);

        //Now there are 2 possibilities
        // #1: max Sum path will go thru left, root and right, meaning travelling up will not give better sum
        //     how do we know this? we don't. That is why we maintain the answer variable globally
        //     we update it in every iteration and finally use its value as answer
        // #2 : Either of left of right leg will be a part of the max sum path
        //      in this case, we add current node value to the max of left sum or right sum
        int maxSumViaEitherOfChildrenOrNodeItSelf = Math.max(currNode.value,currNode.value + Math.max(leftSum, rightSum));
        int maxSumIfBothChildrenAreIncluded = currNode.value + leftSum + rightSum;

        answer = Math.max(maxSumIfBothChildrenAreIncluded, maxSumViaEitherOfChildrenOrNodeItSelf);

        return maxSumViaEitherOfChildrenOrNodeItSelf;

    }
}

class T1 {
    int value;
    public T1(int value) {
        this.value = value;
    }
    T1 left;
    T1 right;
}
