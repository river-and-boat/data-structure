package single;

import common.Node;

public class SingleLinkedTable<T> {
    private final Node<T> first = new Node<>(null, null, null);

    private int size = 0;

    /**
     * add value from first node
     *
     * @param value value
     */
    public void addFirst(T value) {
        if (first.getNext() == null) {
            // linked table is empty
            // single linked table
            first.setNext(new Node<T>(value, null, null));
            size++;
            return;
        }
        Node<T> next = first.getNext();
        first.setNext(new Node<T>(value, null, next));
        size++;
    }

    /**
     * start from index zero
     * add new data after index
     *
     * @param index index
     * @param value node be stored to linked table
     */
    public void add(int index, T value) throws Exception {
        assertCapacity(index);
        Node<T> node = first.getNext();
        if (node == null) {
            first.setNext(new Node<T>(value, null, null));
            size++;
            return;
        }
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        node.setNext(new Node<T>(value, null, null));
        size++;
    }

    /**
     * add value from last node
     *
     * @param value value
     */
    public void addLast(T value) {
        Node<T> last = first.getNext();
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(new Node<T>(value, null, null));
        size++;
    }

    /**
     * get first node
     *
     * @return first node value
     */
    public T getFirst() {
        Node<T> node = first.getNext();
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    /**
     * find the first node which equal to given value
     *
     * @param value given value
     * @return node
     */
    public T findFirst(T value) {
        Node<T> node = first.getNext();
        while (node != null) {
            if (node.getValue() == value) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * get the index value
     *
     * @param index index
     * @return node
     */
    public T get(int index) throws Exception {
        assertCapacity(index);
        Node<T> node = first.getNext();
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    /**
     * get last node
     *
     * @return last node
     */
    public T getLast() {
        Node<T> node = first.getNext();
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node.getValue();
    }

    /**
     * remove first node
     * then the second node will be the new first node
     */
    public void removeFirst() {
        Node<T> node = first.getNext();
        if (node == null) {
            return;
        }
        first.setNext(node.getNext());
        size--;
    }

    /**
     * remove index node
     *
     * @param index index
     */
    public void remove(int index) throws Exception {
        assertCapacity(index);
        Node<T> node = first.getNext();
        Node<T> deletingNode = node.getNext();

        for (int i = 0; i < index - 1; i++) {
            node = node.getNext();
            deletingNode = node.getNext();
        }

        node.setNext(deletingNode.getNext());
        size--;
    }

    /**
     * remove last node
     */
    public void removeLast() {
        Node<T> node = first.getNext();
        Node<T> deletingNode = node.getNext();

        while (deletingNode.getNext() != null) {
            node = node.getNext();
            deletingNode = deletingNode.getNext();
        }

        node.setNext(new Node<>(null, null, null));
        size--;
    }

    /**
     * clear the linked table
     */
    public void clear() {
        first.setNext(new Node<>(null, null, null));
        size = 0;
    }

    /**
     * lined table size
     *
     * @return size
     */
    public int size() {
        return size;
    }

    private void assertCapacity(int index) throws Exception {
        if (size < index) {
            throw new Exception("single linked table capacity not enough");
        }
    }
}
