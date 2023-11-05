package doublylinkedlist;

class InvalidListIndex extends RuntimeException {
    InvalidListIndex(int index) {
        super("Invalid index: " + index + ". Cannot add element to this index.");
    }
}
