package doublylinkedlist;

class Stack<T> extends LinkedList<T> {

    /**
     * Inserting element to the top of the stack
     */
    public void insertOn(T x) {
        super.insert(x);

        // If you don't want to add duplicates
        /*
         * if (!super.contains(x)) { super.insert(x); }
         */
    }

    /**
     * Remove the last element added from the stack
     */
    public T takeOff() {
        int size = super.size();
        return super.removePos(size - 1);
    }
}