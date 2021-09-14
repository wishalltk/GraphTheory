package com.tree;
import java.util.*;
public class LCAProbs {
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(21);
        root.left.right = new Node(4);
        root.right = new Node(11);

        //Node lca =  lcaWhenKeysArePresent(root, 3, 2);
        //System.out.println(lca.value);

        //findLCAinNaiveApproach(root, 211, 4);

        final Node nullableLCA = lcaWhenKeysMayNotBePresent(root, 3, 21);
        printAllAncestors(root,21, list1);
        System.out.println(list1);
        Node ans = lcaForUnsureKeys(root, 3, 21);
        System.out.println(ans.value);
        if(v1 && v2) {
            System.out.println(nullableLCA.value);
        } else {
            System.out.println("No LCA");
        }
PriorityQueue<Integer> pq = new PriorityQueue<>();
     //   pq.remove(fghfj)
    }
    static boolean v1 = false, v2 = false;
    static boolean key1Found = false, key2Found = false;
    private static Node lcaForUnsureKeys(Node node, int key1, int key2) {
        if(node == null) return null;

        Node tmp =  null;
        if(node.value == key1) {
            tmp = node;
            key1Found = true;
        }
        if(node.value == key2) {
            tmp = node;
            key2Found = true;
        }

        Node foundOnLeft = lcaForUnsureKeys(node.left, key1, key2);
        Node foundOnRight = lcaForUnsureKeys(node.right, key1, key2);

        if(tmp != null) return tmp;
        if(foundOnLeft != null && foundOnRight != null) return node;
        return foundOnLeft != null ? foundOnLeft : foundOnRight;
    }
    private static Node lcaWhenKeysMayNotBePresent(Node node, int key1, int key2) {
        if(node == null)
            return null;

        Node tmp = null;

        if(node.value == key1) {
            v1 = true;
            tmp = node;
        } else if(node.value == key2) {
            v2 = true;
            tmp = node;
        }

        Node left = lcaWhenKeysMayNotBePresent(node.left, key1, key2);
        Node right = lcaWhenKeysMayNotBePresent(node.right, key1, key2);

        if(tmp != null)
            return tmp;

        if(left != null && right != null)
            return node;
        return left != null ? left : right;
    }

    private static void findLCAinNaiveApproach(Node root, int key1, int key2) {
        System.out.println("Printing all ancestors");
        printAllAncestors(root, key1, list1);
        printAllAncestors(root, key2, list2);
        if(list1.isEmpty() || list2.isEmpty()) {
            System.out.println("Early exit since no ancestor");
            return;
        }

        Collections.reverse(list1);
        Collections.reverse(list2);
        System.out.println("List 1 : "+list1);
        System.out.println("List 2 : "+list2);
        int sizeOfL1 = list1.size();
        int sizeOfL2 = list2.size();
        int loopCounter = Math.min(sizeOfL1, sizeOfL2);
        Integer ans = null;
        for(int i=0;i<loopCounter;i++) {
            if(!list1.get(i).equals(list2.get(i))) {
                break;
            } else {
                ans = list1.get(i);
            }
        }
        if(ans == null)
            System.out.println("No LCA");
        else
            System.out.println("LCA is "+ans);;
    }

    private static boolean printAllAncestors(Node root, int key, List<Integer> list) {
        if(root == null)
            return false;

        if(root.value == key)
            return true;

        boolean foundOnLeft = printAllAncestors(root.left, key, list);
        boolean foundOnRight = printAllAncestors(root.right, key, list);
        if(foundOnLeft || foundOnRight)   {
            System.out.println(root.value);
            list.add(root.value);
            return true;
        }
        else return false;

    }


    private static Node lcaWhenKeysArePresent(Node node, int key1, int key2) {

        if(node == null)
            return null;

        if(node.value == key1 || node.value == key2)
            return node;

        Node left = lcaWhenKeysArePresent(node.left, key1, key2);
        Node right = lcaWhenKeysArePresent(node.right, key1, key2);

        if(left != null && right != null)
            return node;

        return (left != null)?left:right;
    }
}
