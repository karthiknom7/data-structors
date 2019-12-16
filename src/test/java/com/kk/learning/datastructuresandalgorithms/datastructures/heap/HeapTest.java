package com.kk.learning.datastructuresandalgorithms.datastructures.heap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapTest {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void shouldThrowExceptionWhenHeapIsFull() {
        Heap heap = new Heap(1);
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Heap is full");
        heap.add(7);
        heap.add(8);

    }
    @Test
    public void shouldInsertElementsWithHeapPropertiesSatisfiedWith3Elemenst() {
        Heap heap = new Heap(3);
        heap.add(7);
        heap.add(8);
        heap.add(10);
        assertEquals("[10, 7, 8]", heap.toString());

    }

    @Test
    public void shouldInsertElementsWithHeapPropertiesSatisfied() {
        Heap heap = new Heap(7);
        heap.add(7);
        heap.add(8);
        heap.add(10);
        heap.add(15);
        heap.add(3);
        heap.add(6);
        heap.add(20);
        assertEquals("[20, 10, 15, 7, 3, 6, 8]", heap.toString());


    }

    @Test
    public void shouldDeleteTheRoot() {
        Heap heap = new Heap(7);
        heap.add(7);
        heap.add(8);
        heap.add(10);
        heap.add(15);
        heap.add(3);
        heap.add(6);
        heap.add(20);
        heap.deleteRoot();
        assertEquals("[15, 10, 8, 7, 3, 6]", heap.toString());


    }

    @Test
    public void shouldDoHeapSort() {
        Heap heap = new Heap(7);
        heap.add(7);
        heap.add(8);
        heap.add(10);
        heap.add(15);
        heap.add(3);
        heap.add(6);
        heap.add(20);
        int[] heapSort = heap.heapSort();
        assertEquals("[3, 6, 7, 8, 10, 15, 20]", Arrays.toString(heapSort));

    }

}