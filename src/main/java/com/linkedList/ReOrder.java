package com.linkedList;

public class ReOrder {

    /*
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6
     * 1 -> 6 -> 2 -> 5 -> 3 -> 4
     * */

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);

        first.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
       /* five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine; */

        LinkedListUtils.print(first);
        reOrder(first);
      //  Node revHead = reverseLinkedList(first);
      //  LinkedListUtils.print(revHead);


    }

    static void reOrder(Node start) {
        Node first = start;
        // find the middle start
        Node middle = findMiddle(start);
        //reverse the elements after the middle
        middle.next =  reverseLinkedList(middle.next);
        // insert middle.next between root and root.next
        Node right = middle.next;
        middle.next = null;

        Node beginPointer = first;
        Node middlePointer = right;

        //merge two lists here
        while (middlePointer != null) {
            // get the next pointers of begin and middle
            // cuz will be overwriting them
            Node beginsNext = beginPointer.next;
            Node middlesNext = middlePointer.next;

            // now that we have stored the pointers, lets overwrite them
            beginPointer.next = middlePointer;
            middlePointer.next = beginsNext;

            // advance the begin and middle pointers
            beginPointer = beginsNext;
            middlePointer = middlesNext;
        }
            LinkedListUtils.print(first);
    }

    private static void insertBetween(Node left, Node endNode) {
        Node temp = left.next;
        left.next = endNode;
        endNode.next = temp;
    }


    static Node reverseLinkedList(Node start) {
        Node head;
        head = start;
        Node current = head;
        Node prevNode = null, nextNode = null;
        while (current != null) {
            // #1: Store the current's next node address in nextNode

            nextNode = current.next; // store current's next node address

            // #2: now that current's next node address is saved, update current' next to prevNode

            current.next = prevNode; // overwrite the current's next reference to prev node

            // #3: since prevNode is stored in current's next, overwrite prev node's value with current.

            prevNode = current;

            // #4: now that we have stored the current node reference, assign the nextNode ref to current

            current = nextNode;

        }
        return prevNode;
    }

    static Node findMiddle(Node root) {

        Node node = root;
        Node sp = node;
        Node fp = node;

        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        Node middle = sp;

        System.out.println("middle is " + middle.val);

        return middle;
    }

}
