package com.columbus.linkedlist;

import com.columbus.node.Node;
import java.util.Optional;

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
     * @param node
     */
    public LinkedList(Node node) {
        this.head = node;
        this.length = 1;
    }

    /**
     * Add a node at the beginning of the list
     *
     * @param node
     * @return boolean
     */
    public synchronized boolean add(Node<T> node) {
        if (Optional.ofNullable(node).isPresent()) {
            if (Optional.ofNullable(head).isPresent()) {
                node.setNext(head);
            }
            head = node;
            length++;
            return true;
        }

        return false;
    }

    /**
     * Add a node at the beginning of the list
     *
     * @param node
     * @return boolean
     */
    public synchronized boolean insertAtBeginning(Node<T> node) {
        return add(node);
    }

    /**
     * Add a node at the end of the list
     *
     * @param node
     * @return boolean
     */
    public synchronized boolean insertAtLast(Node<T> node) {
        if (Optional.ofNullable(node).isPresent()) {
            if (Optional.ofNullable(head).isPresent()) {
                Node<T> cursor = head;
                while ((cursor = cursor.getNext()) != null) {
                }
                cursor.setNext(node);
            } else {
                head = node;
            }
            length++;
            return true;
        }
        return false;
    }

    /**
     * Add a node at the i-th position from the start of list
     *
     * @param node
     * @return boolean
     */
    public synchronized boolean insert(int index, Node<T> node) {

        if (index == 0) {
            add(node);
        } else if (index > 0 && index <= length + 1 && Optional.ofNullable(node).isPresent()) {
            if (Optional.ofNullable(head).isPresent()) {
                int i = 0;
                Node<T> cursor = head;
                Node<T> tempNode;

                if (++i < index) {
                    cursor = cursor.getNext();
                }

                tempNode = cursor.getNext();
                node.setNext(tempNode);
                cursor.setNext(node);
                length++;
                return true;
            } else {
                throw new RuntimeException("The head of the Linked List is null.");
            }
        } else {
            String message = Optional.ofNullable(node).isPresent() ? "Invalid Parameters: The node object is null." : "Invalid Parameters: The index specified is not valid.";
            throw new RuntimeException(message);
        }
        return false;
    }

    /**
     * This returns all values from the list in csv format
     *
     * @return String
     */
    public String getValuesInCSV() {
        Node<T> cursor = head;
        String values = "";
        if (Optional.ofNullable(head).isPresent()) {
            int i = 0;
            do {
                values += cursor.getData() + ",";
            } while ((cursor = cursor.getNext()) != null);
            // remove the extra comma at the end
            values += "\b";
        }
        return values;
    }

}
