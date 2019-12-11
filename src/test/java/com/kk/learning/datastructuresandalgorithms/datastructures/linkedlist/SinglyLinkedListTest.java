package com.kk.learning.datastructuresandalgorithms.datastructures.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList linkedList = null;

    @Before
    public void setUp() throws Exception {

        linkedList = new SinglyLinkedList();
        linkedList.insertAtHead(2);
        linkedList.insertAtHead(6);
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(7);
        linkedList.insertAtHead(8);
    }

    @Test
    public void shouldInsertAtHead() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtHead(6);
        assertEquals("[6]", linkedList.toString());
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(7);
        linkedList.insertAtHead(8);
        assertEquals("[8,7,5,6]", linkedList.toString());
    }

    @Test
    public void shouldReturnTheLengthOfLinkedList() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        assertEquals(0, linkedList.length());
        linkedList.insertAtHead(6);
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(7);
        linkedList.insertAtHead(8);
        assertEquals(4, linkedList.length());
    }

    @Test
    public void shouldDeleteNodeFromHead(){
        linkedList.deleteAtHead();
        assertEquals("[7,5,6,2]", linkedList.toString());
        linkedList.deleteAtHead();
        linkedList.deleteAtHead();
        assertEquals("[6,2]", linkedList.toString());
        linkedList.deleteAtHead();
        linkedList.deleteAtHead();
        assertEquals("[]", linkedList.toString());


    }

    @Test
    public void shouldFindAnElement() {
        Integer element = linkedList.findElement(6);
        assertEquals(Integer.valueOf(6), element);
        assertNull(linkedList.findElement(100));
    }

    @Test
    public void shouldNotAppendLastNNodesIfGivenNisGreaterThanLenghtWithoutLenghtVariable() {
        linkedList.appendLastNNodesToHeadWithoutLengthVariable(5);
        assertEquals("[8,7,5,6,2]", linkedList.toString());
    }

    @Test
    public void shouldAppendLastNNodesWithoutLengthVariable() {
        linkedList.appendLastNNodesToHeadWithoutLengthVariable(4);
        assertEquals("[7,5,6,2,8]", linkedList.toString());
    }

    @Test
    public void shouldNotAppendLastNNodesIfGivenNisGreaterThanLenght() {
        linkedList.appendLastNNodesToHead(5);
        assertEquals("[8,7,5,6,2]", linkedList.toString());
    }

    @Test
    public void shouldAppendLastNNodes() {
        linkedList.appendLastNNodesToHead(4);
        assertEquals("[7,5,6,2,8]", linkedList.toString());
    }

    @Test
    public void shouldReverseTheList() {
        linkedList.reverse();
        assertEquals("[2,6,5,7,8]", linkedList.toString());

        linkedList = new SinglyLinkedList();
        linkedList.insertAtHead(9);
        linkedList.insertAtHead(8);
        linkedList.insertAtHead(7);
        linkedList.insertAtHead(4);
        linkedList.insertAtHead(2);
        linkedList.insertAtHead(1);
        assertEquals("[1,2,4,7,8,9]", linkedList.toString());
        linkedList.reverse();
        assertEquals("[9,8,7,4,2,1]", linkedList.toString());

    }


    @Test
    public void shouldRemoveDuplicatesFromList() {

        linkedList = new SinglyLinkedList();
        linkedList.insertAtHead(9);
        linkedList.insertAtHead(8);
        linkedList.insertAtHead(1);
        linkedList.insertAtHead(4);
        linkedList.insertAtHead(9);
        linkedList.insertAtHead(1);
        assertEquals("[1,9,4,1,8,9]", linkedList.toString());
        linkedList.removeDuplicates();
        assertEquals("[1,9,4,8]", linkedList.toString());

    }
}