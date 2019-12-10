package com.kk.learning.datastructuresandalgorithms.datastructures.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedLinkedListTest {

    @Test
    public void insert() {
        SortedLinkedList linkedList = new SortedLinkedList();
        linkedList.insert(9);
        linkedList.insert(4);
        linkedList.insert(7);
        linkedList.insert(2);
        linkedList.insert(2);
        linkedList.insert(5);
        assertEquals("[2,2,4,5,7,9]", linkedList.toString());
    }
}