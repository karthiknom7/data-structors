package com.kk.learning.datastructuresandalgorithms.logical.array;


public class ArrayAestheticCheck {
    public int solution(int[] A) {
        if (isAesthetic(A, -1)) return 0;
        int count = 0;
        for (int i =0; i < A.length ; i++){
            if(isAesthetic(A, i)){
                count++;
            }
        }
        return count> 0 ? count : -1;
    }


    public boolean isAesthetic(int[] arr, int skipIndex) {

        int currentIndex = 0;
        if (currentIndex == skipIndex) currentIndex = currentIndex + 1;

        int nextIndex = currentIndex + 1;
        if (nextIndex == skipIndex) nextIndex = nextIndex + 1;
        boolean nextIsGreater = arr[currentIndex] < arr[nextIndex];
        if (arr[currentIndex] == arr[nextIndex]) return false;

        int length = arr.length;
        if (skipIndex == arr.length - 1) length = length - 1;

        for (currentIndex = 0; currentIndex < length - 1; currentIndex++) {
            nextIndex = currentIndex + 1;
            if (currentIndex == skipIndex) continue;
            if (nextIndex == skipIndex) nextIndex = nextIndex + 1;
            if (arr[currentIndex] == arr[nextIndex]) return false;

            if (nextIsGreater) {
                if (arr[currentIndex] > arr[nextIndex]) {
                    return false;
                }
                nextIsGreater = false;
            } else {
                if (arr[currentIndex] < arr[nextIndex]) {
                    return false;
                }
                nextIsGreater = true;
            }
        }
        return true;
    }
}