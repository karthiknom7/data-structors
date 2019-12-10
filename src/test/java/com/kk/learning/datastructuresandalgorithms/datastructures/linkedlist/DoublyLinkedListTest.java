package com.kk.learning.datastructuresandalgorithms.datastructures.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    @Test
    public void shouldInsertNodes() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(2);
        assertEquals("[1,2]", linkedList.toString());
        linkedList.insertAtEnd(5);
        assertEquals("[1,2,5]", linkedList.toString());
    }

    @Test
    public void shouldInsertDataAtHead() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertAtHead(1);
        linkedList.insertAtHead(3);
        linkedList.insertAtHead(4);
        assertEquals("[4,3,1]", linkedList.toString());
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(7);
        assertEquals("[7,5,4,3,1]", linkedList.toString());
    }


}