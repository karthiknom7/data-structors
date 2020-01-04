package com.kk.learning.datastructuresandalgorithms.datastructures.heap;

import java.util.Arrays;

public class Heap {

    private int[] elements;
    private int currentPosition;


    public Heap(int initialSize) {
        elements = new int[initialSize + 1];
        this.currentPosition = 0;
    }


    public void add(int element) {
        if (currentPosition + 1 < elements.length) {
            elements[++currentPosition] = element;
            if (currentPosition > 1) {
                int current = currentPosition;
                while (elements[current] > elements[parent(current)] && current != 1) {
                    swap(elements, current, parent(current));
                    current = parent(current);
                }
            }
        } else throw new RuntimeException("Heap is full");
    }

    private void swap(int[] elements, int childIndex, int parent) {
        int temp = elements[childIndex];
        elements[childIndex] = elements[parent];
        elements[parent] = temp;
    }

    private int parent(int childPosition) {
        if (childPosition <= 1) return 1;
        return childPosition / 2;


    }

    private boolean isLeaf(int position) {
        return (elements.length / 2)  <= position;
    }

    private int leftChildPosition(int position) {
        return position * 2;
    }

    private int rightChildPosition(int position) {
        return position * 2 + 1;
    }

    @Override
    public String toString() {
        int destArra[] = new int[elements.length-1];
        System.arraycopy(elements, 1, destArra, 0, elements.length-1);
        return Arrays.toString(destArra);
    }

    public int deleteRoot() {
        int rootEle = elements[1];
        elements[1] = elements[currentPosition];
        elements[currentPosition--] = 0;
        heapify(1);
        return rootEle;
    }

    private void heapify(int position) {
        if (isLeaf(position)) return;
        int left = leftChildPosition(position);
        int right = rightChildPosition(position);
        int greaterChild = elements[left] > elements[right] ? left : right;
        if (elements[position] < elements[greaterChild]) {
            swap(elements, greaterChild, position);
            heapify(greaterChild);
        }
    }

    public int[] heapSort() {
        int[] sortedArray = new int[elements.length];
        int currentSize = currentPosition;
        while (currentSize >= 1) {
            int root = this.deleteRoot();
            sortedArray[currentSize-1] = root;
            currentSize --;
        }
        return sortedArray;
    }
}
