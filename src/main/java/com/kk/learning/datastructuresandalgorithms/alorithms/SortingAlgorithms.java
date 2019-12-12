package com.kk.learning.datastructuresandalgorithms.alorithms;

public class SortingAlgorithms {


    // Complexity of this is O(n^2)
    // Find largest and move to end of array
    public int[] bubbleSort(int input[]){
        int length = input.length;
        // O(n)
        for(int i = 0; i < length; i++){
            // O(n)
            for(int j=0; j< length-1-i ; j++ ){
                if(input[j] > input[j+1]){
                    swap(input, j, j+1);
                }
            }
        }
        return input;
    }


    // Find smallest and move to start of array
    //O(n^2)
    public int[] selectionSort(int[] input){
        int length = input.length;
        for(int i =0; i < length ; i++){
            int smallIndex = i;
            for (int j =i; j < length - 1; j++){
                if(input[j] < input[smallIndex]){
                    smallIndex = j;
                }
            }
            swap(input, smallIndex, i);
        }
        return input;
    }

    // Select an element compare with each element of left side of an array and swap if it's smaller than left side element
    // O(n^2)
    public void insertionSort(int[] input){
        int length = input.length;
        for(int i =0; i < length - 1  ; i++){
            for(int j = i + 1 ; j >0 ; j--){
                if(input[j] < input[j-1]){
                    swap(input, j, j-1);
                }
            }
        }
    }


    private void swap(int[] input, int index1, int index2){
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }


    public void mergeSort(int[] input){
        mergeSort(input, 0, input.length-1);
    }

    private void mergeSort(int[] input, int start, int end){

        if(start < end){
            int mid = (start + end)/2;
            mergeSort(input, start, mid);
            mergeSort(input, mid+1, end);
            merge(input, start, mid, end);
        }

    }

    private void merge(int[] input, int start, int mid, int end ){

        int[] left = new int[mid-start+1];
        int[] right = new int[end-mid];
        for(int leftIndex =0; leftIndex < left.length; leftIndex ++){
            left[leftIndex]= input[start + leftIndex];
        }
        for(int rightIndex =0; rightIndex < right.length; rightIndex ++ ){
            right[rightIndex] = input[mid+1+rightIndex];
        }
        int leftIndex = 0, rightIndex = 0;
        int inputIndex =start;
        while (leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex] < right[rightIndex]){
                input[inputIndex] = left[leftIndex++];
            }else {
                input[inputIndex] = right[rightIndex++];
            }
            inputIndex++;
        }
        while (leftIndex < left.length){
            input[inputIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length){
            input[inputIndex++] = right[rightIndex++];
        }

    }
}
