package doublylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedList<T> implements Methods<T> {

    // Start and end reference to list
    private Node head;
    private Node tail;

    // Node class
    class Node {
        Node next;
        Node prev;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    // --- ITERATOR METHOD AND CLASS ---

    // Return class being iterated over
    public Iterator<T> iterator() {
        return new LinkedListIterator(this);
    }

    /**
     * Private Iterator class
     */
    private class LinkedListIterator implements Iterator<T> {

        private final LinkedList<T> linkedList;
        private int index = 0;

        int size = size();

        LinkedListIterator(LinkedList<T> linkedList) {
            this.linkedList = linkedList;
        }

        /**
         * Return true if there list has a next element
         */
        public boolean hasNext() {
            return index < size;
        }

        /**
         * Returns data from next element. Throws exception if
         * there is no next element
         */
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return linkedList.get(index++);
        }
    }

    // --- LINKED LIST METHODS ---

    /**
     * Return LinkedList size
     */
    public int size() {
        Node ptr = head;
        int counter = 0;

        while (ptr != null) {
            ptr = ptr.next;
            counter++;
        }
        return counter;
    }

    /**
     * If true, the list contains the element
     */
    public boolean contains(T x) {
        int size = size();

        if (size == 0) {
            return false;
        }

        // Looping through list to find element
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(x)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Insert element at Nth position and push everything one index backwards
     */
    public void insertPos(int pos, T x) throws InvalidListIndex {
        Node newN = new Node(x);
        int size = size();

        if (pos > size || pos < 0) {
            throw new InvalidListIndex(pos);
        }

        if (size == 0) {
            head = newN;
            tail = newN;
        } else if (pos == size) {
            tail.next = newN;
            newN.prev = tail;
            tail = newN;
        } else if (pos == 0) {
            newN.next = head;
            head.prev = newN;
            head = newN;
        } else {
            Node ptr = head;

            for (int i = 0; i < pos - 1; i++) {
                ptr = ptr.next;
            }

            newN.next = ptr.next;
            newN.prev = ptr;
            ptr.next.prev = newN;
            ptr.next = newN;
        }
    }

    /**
     * Insert something at the end of the list
     */
    public void insert(T x) {
        Node newN = new Node(x);

        if (isEmpty()) {
            head = newN;
        } else {
            tail.next = newN;
            newN.prev = tail;
        }
        tail = newN;
    }

    /**
     * Set data in given position and overwrite the data that is already there
     */
    public void set(int pos, T x) throws InvalidListIndex {
        Node ptr = head;
        int size = size();

        if (pos > size - 1 || pos < 0) {
            throw new InvalidListIndex(pos);
        } else if (isEmpty()) {
            head = tail;
        } else {
            for (int i = 0; i < pos; i++)
                ptr = ptr.next;

            ptr.data = x;
        }
    }

    /**
     * Get element T in given position and return elements data
     */
    public T get(int pos) throws InvalidListIndex {
        Node ptr = head;
        int size = size();

        if (pos > size - 1 || pos < 0) {
            throw new InvalidListIndex(pos);
        }

        for (int i = 0; i < pos; i++) {
            ptr = ptr.next;
        }
        return ptr.data;
    }

    /**
     * Remove element T in given position and return elements data
     */
    public T removePos(int pos) throws InvalidListIndex {
        Node ptr = head;
        int size = size();

        // Taking care of edge cases.
        if (pos > size - 1 || pos < 0) {
            throw new InvalidListIndex(pos);
        }

        if (size == 1) {
            head = tail = null;
        } else if (pos == 0) {
            head.next.prev = null;
            head = ptr.next;
        } else if (pos == size - 1) {
            ptr = tail;
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            for (int i = 0; i < pos; i++) {
                ptr = ptr.next;
            }
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
        }
        return ptr.data;
    }

    /**
     * Remove element T from the start of the list
     * and return its data
     */
    public T remove() throws InvalidListIndex {
        if (isEmpty()) {
            throw new InvalidListIndex(0);
        }

        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;

        return temp.data;
    }

    /**
     * Delete last element from list and return its data
     */
    public T removeLast() throws InvalidListIndex {
        if (isEmpty()) {
            throw new InvalidListIndex(0);
        }
        Node ptr = tail;

        while (ptr.next != null) {
            ptr = ptr.next;
        }

        tail = tail.prev;
        tail.next = null;
        ptr.prev = null;

        return ptr.data;
    }

    /**
     * Printing out entire list
     */
    public void printAllObj() {
        Node ptr = head;
        int index = 0;

        if (ptr == null) {
            System.out.println("The list is empty");
        }
        System.out.println();

        System.out.println("--- ELEMENTS IN LINKED LIST ---");

        while (ptr != null) {
            System.out.println("Index " + index + ": " + ptr.data);
            ptr = ptr.next;
            index++;
        }
        System.out.println();
    }

    // --- HELP METHODS ---

    /**
     * If true, list is empty
     */
    private boolean isEmpty() {
        return head == null;
    }

    /**
     * Get head pointer in list
     */
    protected Node getHead() {
        return head;
    }
}
