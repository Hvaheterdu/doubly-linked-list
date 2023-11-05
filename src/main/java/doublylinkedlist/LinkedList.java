package doublylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedList<T> implements Methods<T> {

    private Node head;
    private Node tail;

    protected class Node {
        protected Node next;
        protected Node prev;
        protected T data;

        protected Node(T data) {
            this.data = data;
        }
    }

    // --- ITERATOR METHOD AND CLASS ---

    public Iterator<T> iterator() {
        return new LinkedListIterator(this);
    }

    private class LinkedListIterator implements Iterator<T> {

        private final LinkedList<T> linkedList;
        private int index = 0;

        int size = size();

        private LinkedListIterator(LinkedList<T> linkedList) {
            this.linkedList = linkedList;
        }

        public boolean hasNext() {
            return index < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return linkedList.get(index++);
        }
    }

    // --- LINKED LIST METHODS ---

    public int size() {
        Node ptr = head;
        int counter = 0;

        while (ptr != null) {
            ptr = ptr.next;
            counter++;
        }

        return counter;
    }

    public boolean contains(T x) {
        int size = size();

        if (size == 0) {
            return false;
        }

        for (int i = 0; i < size(); i++) {
            if (get(i).equals(x)) {
                return true;
            }
        }

        return false;
    }

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

    public T removePos(int pos) throws InvalidListIndex {
        Node ptr = head;
        int size = size();

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

    private boolean isEmpty() {
        return head == null;
    }

    protected Node getHead() {
        return head;
    }
}
