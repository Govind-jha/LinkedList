package com.columbus.node;

import com.columbus.node.Node;
import org.assertj.core.api.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import static org.junit.Assert.*;

/**
 * This is the Test for a @{@link Node} object.
 *
 * This is a visualization of the node object that we are going to test.
 * head{1, --}--> node{5, null}
 */
public class NodeTest {

    private Node<String> head, node;

    @Before
    public void setUp(){
        // head{1, node}
        head = new Node("1",node);
        // node{5, null}
        node = new Node("5", null);
    }

    @Test
    public void testGetData(){
        assertThat(node.getData()).as("data is equal the data stored in the node object node{5, null}").isEqualTo("5");
    }

    @Test
    public void testSetData(){
        node.setData("0");
        assertThat(node.getData()).as("data is equal to the data stored in the node{0, null}").isEqualTo("0");
    }

    @Test
    public void testGetNext(){
        Node<String> testNode = new Node();
        testNode.setData("5");
        testNode.setNext(null);

        // This works because we have overridden the equals() and hashCode() method in class Node
        assertThat(node).as("node and testNode{5, null} are equal.").isEqualTo(testNode);
    }

    @Test
    public void testSetNext(){
        Node<String> testNode = new Node();
        testNode.setData("3");
        testNode.setNext(null);

        node.setNext(testNode);

        // This works similar to the use of isEqualTo() in the test above,
        // without us explicitly overriding equals() and hashCode() method in the class Node
        assertThat(node.getNext()).as("node and testNode{3, null} are equal.").isSameAs(testNode);
    }
}