package com.columbus.node;

/**
 * Node is a representation of a simplest element in a Linked List.
 * The Node object can hold an Object data and a reference to the next node in a Linked List.
 * This can be represented as Node{data, pointer}.
 *
 * @param <T>
 *     T Object
 */
public class Node<T> {
    /**
     * This stores the data for the node.
     */
     private T data;

    /**
     * This stores the pointer to the next node from the node.
     */
     private Node next;


    /**
     * Constructor for creating an instance of the Node object.
     * This represents an node with no next pointer assigned to it yet.
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * Constructor for creating a node with data value and pointer to the next node.
     *
     * @param data
     * @param next
     */
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    /**
     * This method returns data for the node.
     * @return Object
     */
    public T getData() {
        return data;
    }

    /**
     * This method sets the data for the node.
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * This method sets next for the node.
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * This method returns next for the node.
     * @return @{@link Node<T>}
     */
    public Node getNext() {
        return next;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Node)) return false;

        Node<?> node = (Node<?>) obj;

        if (!getData().equals(node.getData())) return false;
        return getNext() != null ? getNext().equals(node.getNext()) : node.getNext() == null;
    }

    @Override
    public int hashCode() {
        int result = getData().hashCode();
        result = 31 * result + (getNext() != null ? getNext().hashCode() : 0);
        return result;
    }
}
