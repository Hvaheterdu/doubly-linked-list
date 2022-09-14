package doublylinkedlist;

class InvalidListIndex extends RuntimeException {

    /**
     * Print message when index is invalid
     * 
     * @param index: index that is entered
     */
    InvalidListIndex(int index) {
        super("Invalid index: " + index + ". Cannot add element to this index.");
    }
}
