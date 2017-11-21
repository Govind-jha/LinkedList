package com.columbus.linkedlist;

import com.columbus.node.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<Integer>();
        list.add(new Node<Integer>(4));
        list.add(new Node<Integer>(2));
        list.add(new Node<Integer>(1));
        list.add(new Node<Integer>(0));
    }

    @Test
    public void testAdd() throws Exception {
    }

    @Test
    public void testInsertAtBeginning() throws Exception {
    }

    @Test
    public void testInsertAtLast() throws Exception {
    }

    @Test
    public void testInsert() throws Exception {
    }

    @Test
    public void testGetValuesInCSV() throws Exception {

    }

}