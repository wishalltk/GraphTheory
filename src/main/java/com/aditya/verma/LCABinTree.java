package com.aditya.verma;

public class LCABinTree {
    static boolean v1 = false;
    static boolean v2 = false;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

/*        Node and = new LowestCommonAncestorInBinaryTree().lca(root, new Node(2), new Node(3));
        System.out.println(and.value);*/

        Node ans = lca(root, 99,99);
            System.out.println(ans.value);
    }

    static Node lca(Node curNode, int n1, int n2) {

        // base case 1 : we hit the bottom of tree and found no match
        if(curNode == null)
            return null;

        // base case 2: lets check if the current node is either of the 2 nodes
        // if it matches with anything, we need to propagate this node to all the way till top
//        if(curNode.value == n1 || curNode.value == n2)
//            return curNode;

        if(curNode.value == n1) {
            v1 = true;
            return curNode;
        }
        if(curNode.value == n2) {
            v2 = true;
            return curNode;
        }

        // choice diagrams: we need to go left and right
        Node leftResult = lca(curNode.left, n1, n2);
        Node rightResult = lca(curNode.right, n1, n2);

        // results can be matching nodes or null. We will interpret the situation based on this
        if(leftResult != null && rightResult != null) {
            // means the n1 and n2 are on the left and right sides of the current node
            // that means the current node is the lca
            return curNode;
        }

        return leftResult != null ? leftResult : rightResult;
    }

    static Node findLCA(Node node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.value == n1 || node.value == n2)
            return node;

        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
}



class LowestCommonAncestorInBinaryTree {

    public Node lca(Node root, Node n1, Node n2){
        if(root == null){
            return null;
        }
        if(root == n1 || root == n2){
            return root;
        }

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}
