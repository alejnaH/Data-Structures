package week1;

import java.util.Iterator;

public class DoublyLinkedList<Data> implements Iterable<Data> {
    private DoubleNode<Data> head;
    private DoubleNode<Data> tail;
    private int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }

    /* Add a new node to the front of the doubly linked list */
    public void addToFront(Data data) {

        DoubleNode<Data> newNode = new DoubleNode<>();
        newNode.data = data;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /* Remove a node from the front of the doubly linked list */
    public void removeFromFront() {

        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head.next.prev = null;
                head = head.next;
            }
            size--;
        }
    }

    /* Add a new node to the end of the doubly linked list */
    public void addToRear(Data data) {

        DoubleNode<Data> newNode = new DoubleNode<>();

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    /* Remove a node at the end of the doubly linked list */
    public void removeFromRear() {
        // your code
    }

    /* Get a linked list node by index (0-indexed) */
    public Data get(int index) {
        // your code
        return null;
    }

    /* Add an element to a doubly linked list by index (0-index) */
    public void add(int index, Data data) {
        // your code
    }

    /* Delete an element from a doubly linked list by index (0-index) */
    public void remove(int index) {
        // your code
    }

    /* Return the current size of the doubly linked list */
    public int count() {
        //your code
        return 0;
    }

    /* Return an Iterator Object */
    @Override
    public Iterator<Data> iterator() {
        //your code
        return null;
    }

    /* Define the Iterator class, and hasNext() and next() methods */
    private class DoublyLinkedListIterator implements Iterator<Data> {
        //your code

        @Override
        public boolean hasNext() {
            //your code
            return false;
        }

        @Override
        public Data next() {
            //your code
            return null;
        }
    }

    /* Get head node (for test purposes) */
    public DoubleNode<Data> getHead() {
        return head;
    }

    /* Get tail node (for test purposes) */
    public DoubleNode<Data> getTail() {
        return tail;
    }
}