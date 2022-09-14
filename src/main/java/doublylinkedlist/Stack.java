package doublylinkedlist;

class Stack<T> extends LinkedList<T> {

    /**
     * Inserting to the end of the list
     * 
     * @param x: element to insert
     */
    public void insertOn(T x) {
        super.insert(x);

        // If you don't want to add duplicates
        /*
         * if (!super.contains(x)) { super.insert(x); }
         */
    }

    /**
     * Remove the last element added from the list
     * 
     * @return last element from list
     */
    public T takeOff() {
        int size = super.size();
        return super.removePos(size - 1);
    }
}