package com.columbus.linkedlist;

import com.columbus.node.Node;

import java.util.Optional;

@SuppressWarnings("ALL")
public class LinkedList<T> {


    /**
     * This holds the head of the list
     */
    private Node<T> head;

    /**
     * This hold the length of the list
     */
    private int length;

    /**
     * Constructor to create an empty Linked List
     */
    public LinkedList() {
        this.length = 0;
    }

    /**
     * Constructor to create a Linked List with node as the head
     *
     * @param @{@link Node}
     */
    public LinkedList(Node node) {
        this.head = node;
        this.length = 1;
    }

    /**
     * This returns the length of the list
     *
     * @return int
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Add a node at the beginning of the list
     *
     * @param @{@link Node}
     * @return boolean
     */
    public synchronized boolean add(Node<T> node) {

        if (!Optional.ofNullable(node).isPresent()) {
            throw new RuntimeException("ERROR: Tried to insert a null node into the list");
        }

        if (this.length == 0) {
            this.head = node;
            this.length = 1;
        } else {
            node.setNext(head);
            this.head = node;
            this.length++;
        }

        return true;
    }

    /**
     * Add a node at the beginning of the list
     *
     * @param @{@link Node}
     * @return boolean
     */
    public synchronized boolean insertAtBeginning(Node<T> node) {
        return add(node);
    }

    /**
     * Add a node at the end of the list
     *
     * @param @{@link Node}
     * @return boolean
     */
    public synchronized boolean insertAtLast(Node<T> node) {

        if (!Optional.ofNullable(node).isPresent()) {
            throw new RuntimeException("ERROR: Tried to insert a null node into the list");
        }

        if (this.length == 0) {
            this.head = node;
            this.length = 1;
        } else {
            int cursor = 0;
            Node<T> pointer = head;

            while (++cursor < this.length) {
                pointer = pointer.getNext();
            }

            pointer.setNext(node);
            this.length++;
        }

        return true;
    }

    /**
     * Add a node at the i-th position from the start of list
     * Index starts with 0 and can have maximum value equal to
     * the length of the list i.e. the position next to last node.
     *
     * @param @{@link Node}
     * @return boolean
     */
    public synchronized boolean insert(int index, Node<T> node) {
        if (!Optional.ofNullable(node).isPresent()) {
            throw new RuntimeException("ERROR: Tried to insert a null node into the list");
        }

        if (index < 0 || index > length) {
            throw new RuntimeException("ERROR: Index is out of bounds [0, length].");
        }

        if (index == 0) {
            add(node);
        } else if (index == this.length) {
            insertAtLast(node);
        } else {
            int cursor = 0;
            Node<T> pointer = head, tempNode;

            while (++cursor < index) {
                pointer = pointer.getNext();
            }

            tempNode = pointer.getNext();
            pointer.setNext(node);
            node.setNext(tempNode);
            this.length++;
        }

        return true;
    }

    /**
     * This returns all values from the list in csv format
     *
     * @return String
     */
    public String getValuesAsCSV() {
        assert null != head;
        Node<T> cursor = head;

        StringBuilder values = new StringBuilder().append(this.head.getData());
        while (Optional.ofNullable(cursor = cursor.getNext()).isPresent()) {
            values.append(",");
            values.append(cursor.getData());
        }

        return values.toString();
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "list=" + getValuesAsCSV() +
                ", length=" + length +
                '}';
    }
}
