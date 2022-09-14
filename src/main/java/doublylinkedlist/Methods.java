package doublylinkedlist;

interface Methods<T> extends Iterable<T> {

    int size();

    boolean contains(T x);

    void insertPos(int pos, T x);

    void insert(T x);

    void set(int pos, T x);

    T get(int pos);

    T removePos(int pos);

    T remove();

    T removeLast();
}
