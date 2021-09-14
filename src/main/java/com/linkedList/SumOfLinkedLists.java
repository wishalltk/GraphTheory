package com.linkedList;

import java.util.Random;

public class SumOfLinkedLists {
    public static void main(String[] args) {
        LNode1 root1 = new LNode1(2);
        root1.next = new LNode1(4);
        root1.next.next = new LNode1(3);

        LNode1 root2 = new LNode1(5);
        root2.next = new LNode1(6);
        root2.next.next = new LNode1(4);

        LNode1 answer = sumLinkedLists(root1, root2);
        printLinkedList(answer);
    }

    private static void printLinkedList(LNode1 answer) {
        LNode1 root = answer;
        while (root !=  null) {
            System.out.print(root.data+" --> ");
            root = root.next;
        }
        System.out.println("NULL");
    }

    private static LNode1 sumLinkedLists(LNode1 root1, LNode1 root2) {
        int carry = 0;

        LNode1 fakeNowLegitLater = new LNode1(0); // random value. In the end, we will return the next node which discards the zero node
        LNode1 proxyPointer = fakeNowLegitLater; // This guy's address will change everytime we add a new node

        while (root1 != null || root2 != null) {
            /*
            int randomValue = random.nextInt(100);
            LNode1 freshNode = new LNode1(randomValue);
            //insert fresh node to the tail of fake node indirectly via proxy
            proxyPointer.next = freshNode;
            //the above line updates the next node mentioned via both proxy and fake pointers since they both have same address
            // next is to advance proxy's address to the next node
            // next node is anyways added to the tail of fake node, so we no longer need the current proxy node
            proxyPointer = proxyPointer.next;
            // in the next iteration, when we will add a fresh node to proxyPointer.next, it will get appended to the
            // tail of fake pointer
            */
            int sum=0;
            if(root1 != null) {
                sum += root1.data;
                root1 = root1.next;
            }

            if(root2 != null) {
                sum += root2.data;;
                root2 = root2.next;
            }

            sum += carry;
            carry = 0;

            if(sum > 9) {
                carry = 1;
                sum = sum - 10;
            }

            LNode1 freshNode = new LNode1(sum);
            proxyPointer.next = freshNode;
            proxyPointer = proxyPointer.next;

        }

        if(carry > 0) {
            proxyPointer.next = new LNode1(carry);
        }

        return fakeNowLegitLater.next;
    }


}

class LNode1 {

    public LNode1(int data) {
        this.data = data;
    }

    int data;
    LNode1 next;
}
