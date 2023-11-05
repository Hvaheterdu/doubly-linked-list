package doublylinkedlist;

class Stack<T> extends LinkedList<T> {

    public void insertOn(T x) {
        if (super.contains(x)) {
            return;
        } else {
            super.insert(x);
        }
    }

    public T takeOff() {
        int size = super.size();
        return super.removePos(size - 1);
    }
}
