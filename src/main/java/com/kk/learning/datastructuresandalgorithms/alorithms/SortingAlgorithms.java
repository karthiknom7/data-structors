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
}
