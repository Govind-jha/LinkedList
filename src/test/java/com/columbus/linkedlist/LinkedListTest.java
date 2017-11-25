package com.columbus.linkedlist;

import com.columbus.node.Node;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LinkedListTest {
    private LinkedList<Integer> list, listToPrint;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<>();
    }

    @Test
    public void testAddWithNull() {
        assertThatThrownBy(() -> {
            list.add(null);
        }).as("Adding null node to list throws exception").hasMessage("ERROR: Tried to insert a null node into the list");
    }

    @Test
    public void testAdd() throws Exception {
        assert list.add(new Node<Integer>(1));
        assert list.add(new Node<Integer>(2));
        assert list.add(new Node<Integer>(3));
        assert list.getLength() == 3;

        assertThat("3,2,1").as("The values are  inserted on top in LinkedList").isEqualTo(list.getValuesAsCSV());
    }

    @Test
    public void testInsertAtBeginningWithNull() {
        assertThatThrownBy(() -> {
            list.insertAtBeginning(null);
        }).as("Adding null node to list throws exception").hasMessage("ERROR: Tried to insert a null node into the list");
    }

    @Test
    public void testInsertAtBeginning() throws Exception {
        assert list.insertAtBeginning(new Node<Integer>(1));
        assert list.insertAtBeginning(new Node<Integer>(2));
        assert list.insertAtBeginning(new Node<Integer>(3));
        assert list.getLength() == 3;

        assertThat("3,2,1").as("The values are  inserted on top in LinkedList").isEqualTo(list.getValuesAsCSV());
    }

    @Test
    public void testInsertAtLastWithNull() {
        assertThatThrownBy(() -> {
            list.insertAtLast(null);
        }).as("Adding null node to list throws exception").hasMessage("ERROR: Tried to insert a null node into the list");
    }

    @Test
    public void testInsertAtLast() throws Exception {

        assert list.insertAtLast(new Node<Integer>(1));
        assert list.insertAtLast(new Node<Integer>(2));
        assert list.insertAtLast(new Node<Integer>(3));
        assert list.getLength() == 3;
        assertThat("1,2,3").as("The values are  added at bottom of LinkedList").isEqualTo(list.getValuesAsCSV());
    }

    @Test
    public void testInsertWithNull() {
        assertThatThrownBy(() -> {
            list.insert(0,null);
        }).as("Adding null node to list throws exception").hasMessage("ERROR: Tried to insert a null node into the list");
    }

    @Test
    public void testInsertWithIndexNegative() {
        assertThatThrownBy(() -> {
            list.insert(0,null);
        }).as("Adding null node to list throws exception").hasMessage("ERROR: Tried to insert a null node into the list");
    }

    @Test
    public void testInsertWithIndexMoreThanLength() {
        assertThatThrownBy(() -> {
            list.insert(0,null);
        }).as("Adding null node to list throws exception").hasMessage("ERROR: Tried to insert a null node into the list");
    }

    @Test
    public void testInsert() throws Exception {
        assert list.insert(0, new Node<Integer>(3));
        assert list.insert(1, new Node<Integer>(2));
        assert list.insert(2, new Node<Integer>(1));
        assert list.insert(1, new Node<Integer>(4));
        assert list.getLength() == 4;

        assertThat("3,4,2,1").as("The values are  added at bottom of LinkedList").isEqualTo(list.getValuesAsCSV());
    }

    @Test
    public void testGetValuesAsCSV() throws Exception {
        assert list.add(new Node<Integer>(2));
        assert list.insertAtLast(new Node<Integer>(3));
        assert list.insertAtBeginning(new Node<Integer>(1));
        assert list.add(new Node<Integer>(4));
        assert list.getLength() == 4;

        assertThat("4,1,2,3").as("List should print 4,3,2,1").isEqualTo(list.getValuesAsCSV());
    }

}