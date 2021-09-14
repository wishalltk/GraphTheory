package com.linkedList;

public class LLTest {
    static MyNode123 proxyPointer = null;
    static MyNode123 fakePointer = null;
    public static void main(String[] args) {
        fakePointer = new MyNode123(0);
        proxyPointer = fakePointer;
        recuMethod(10);
//        MyNode123 some = new MyNode123(123);
//        copy.next = some;
//        copy = copy.next;
//        System.out.println(copy);
    }

    static void recuMethod(int num) {
        int count = 5;
        while (count-->0) {
            proxyPointer.next = new MyNode123(num); // this will update the final answer linked list
            num+=1;
            proxyPointer = proxyPointer.next; // now i need to move the cursor to the new node for further updates

        }
    }
}

class MyNode123 {

    public MyNode123(int value) {
        this.value = value;
    }

    boolean hasNext() {
        return null != next;
    }

    int value;
    MyNode123 next;
}
