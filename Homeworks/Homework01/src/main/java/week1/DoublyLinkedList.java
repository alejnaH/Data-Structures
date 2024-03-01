package week1;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        }
        else {
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
            }
            else {
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
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    /* Remove a node at the end of the doubly linked list */
    public void removeFromRear() {

        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;
            }
            else {
                tail.prev.next = null;
                tail = tail.prev;
            }
            size--;
        }
    }

    /* Get a linked list node by index (0-indexed) */
    public Data get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        DoubleNode<Data> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /* Add an element to a doubly linked list by index (0-index) */
    public void add(int index, Data data) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        if (index == 0) {
            addToFront(data);
        }
        else if (index == size) {
            addToRear(data);
        }
        else {
            DoubleNode<Data> newNode = new DoubleNode<>();
            newNode.data = data;

            DoubleNode<Data> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.prev = current;
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
    }

    /* Delete an element from a doubly linked list by index (0-index) */
    public void remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        if (index == 0) {
            removeFromFront();
        }
        else if (index == size - 1) {
            removeFromRear();
        }
        else {
            DoubleNode<Data> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.prev.next = current.next; // Updates the next reference of the previous node
            current.next.prev = current.prev; // Updates the previous reference of the next node
            size--;
        }

    }

    /* Return the current size of the doubly linked list */
    public int count() {
            return size;
    }

    /* Return an Iterator Object */
    @Override
    public Iterator<Data> iterator() {
        return new DoublyLinkedListIterator();
    }

    /* Define the Iterator class, and hasNext() and next() methods */
    private class DoublyLinkedListIterator implements Iterator<Data> {

        private DoubleNode<Data> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Data next() {

            if (!hasNext()) {
                throw new NoSuchElementException("No next element.");
            }

            Data data = current.data;
            current = current.next;
            return data;
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