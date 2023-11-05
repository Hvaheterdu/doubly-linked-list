package doublylinkedlist;

class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {

    @Override
    public void set(int pos, T x) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insertPos(int pos, T x) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

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

    @Override
    public T remove() {
        int size = super.size();
        return super.removePos(size - 1);
    }
}
