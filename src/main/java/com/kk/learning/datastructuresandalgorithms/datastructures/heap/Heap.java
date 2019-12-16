package com.kk.learning.datastructuresandalgorithms.datastructures.heap;

import java.util.Arrays;

public class Heap {

    private int[] elements;
    private int size;


    public Heap(int size){
        elements = new int[size];
        this.size = -1;
    }


    public void add(int element) {
        if(size + 1 < elements.length){
            elements[++size] = element;
            if(size > 0) {
                int current = size;
                while (elements[current] > elements[parent(current)]){
                    swap(elements, current, parent(current));
                    current = parent(current);
                }
            }
        }else throw new RuntimeException("Heap is full");
    }

    private void swap(int[] elements, int childIndex, int parent) {
        int temp = elements[childIndex];
        elements[childIndex] = elements[parent];
        elements[parent] = temp;
    }

    private int parent(int childPosition){
        int add = childPosition % 2 == 0 ? 2 : 1;
        int parent = childPosition - add;
        if(parent <= 0) return 0;
        return parent / 2;


   }

   private boolean isLeaf(int position){
        return (elements.length / 2) <= position;
   }

   private int leftChildPosition(int position){
        return position * 2 + 1;
   }

   private int rightChildPosition(int position){
        return position * 2 + 2;
   }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size+1));
    }

    public int deleteRoot() {
        int rootEle = elements[0];
        elements[0] = elements[size];
        elements[size--] = 0;
        heapify(0);
        return rootEle;
    }

    private void heapify(int position){
        if(isLeaf(position)) return;
        int left = leftChildPosition(position);
        int right = rightChildPosition(position);
        int greaterChild = elements[left] > elements[right] ? left : right;
        if(elements[position] < elements[greaterChild]){
            swap(elements, greaterChild, position);
            heapify(greaterChild);
        }
    }

    public int[] heapSort(){
        int[] sortedArray = new int[elements.length];
        int currentSize = size;
        while (currentSize >=0){
            int root = this.deleteRoot();
            sortedArray[currentSize--] = root;
        }
        return sortedArray;
    }
}
