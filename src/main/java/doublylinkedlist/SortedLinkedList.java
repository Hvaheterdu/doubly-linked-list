package doublylinkedlist;

class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {

    /**
     * @throws UnsupportedOperationException
     * because method should not work in this class
     */
    @Override
    public void set(int pos, T x) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException
     * because method should not work in this class
     */
    @Override
    public void insertPos(int pos, T x) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Checks if element is in list
     */
    @Override
    public boolean contains(T x) {
        if (super.size() == 0) {
            return false;
        }

        // Looping through list to find element
        for (int i = 0; i < size(); i++) {
            if (super.get(i).compareTo(x) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Insert item in a sorted manner in list
     */
    @Override
    public void insert(T x) {
        int size = super.size();
        int counter = 0;

        if (super.contains(x)) {
            return;
        }

        if (size == 0) {
            super.insert(x);
        } else {
            Node ptr = getHead();

            while (counter < size && ptr.data.compareTo(x) <= 0) {
                ptr = ptr.next;
                counter++;
            }
            super.insertPos(counter, x);
        }
    }

    /**
     * Remove from end of the list and return data to removed element
     */
    @Override
    public T remove() {
        int size = super.size();
        return super.removePos(size - 1);
    }
}
