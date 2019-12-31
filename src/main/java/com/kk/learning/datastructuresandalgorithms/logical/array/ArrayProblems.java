package com.kk.learning.datastructuresandalgorithms.logical.array;

import java.util.Arrays;

public class ArrayProblems {

    public int findSecondLargest(int[] data) {
        int largest = 0;
        int secondLargest = 0;
        for (int ele : data) {
            if (ele > largest) {
                secondLargest = largest;
                largest = ele;
            } else if (ele > secondLargest && ele != largest) {
                secondLargest = ele;
            }
        }
        return secondLargest;
    }


    public void reverseArray(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int temp;
        while (endIndex > startIndex) {
            temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
            endIndex--;
            startIndex++;
        }
    }


    public void rotateArrayBy(int times, int[] array) {
        int length = array.length;
        for (int i = 0; i < times; i++) {
            int rotateEle = array[0];
            for (int j = 0; j < length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[length - 1] = rotateEle;
        }
    }


    public int[] removeDuplicates(int[] array) {
        int length = array.length;
        int[] result = new int[length];
        int resultIndex = 0;
        for (int index = 0; index < length - 1; index++) {
            if (array[index] != array[index + 1]) {
                result[resultIndex++] = array[index];
            }
        }
        result[resultIndex] = array[length - 1];

        int finalResult[] = new int[resultIndex + 1];
        for (int index = 0; index <= resultIndex; index++) {
            finalResult[index] = result[index];
        }
        return finalResult;
    }

    public int numberOfpossibleTriangles(int[] array) {
        if (array.length < 3) {
            return 0;
        }

        int triangles = 0;
        for (int i = 0; i < array.length - 2; i++) {
            int j = i + 1;
            while (j < array.length - 1) {
                int k = j + 1;
                while (k < array.length) {
                    int num1 = array[i];
                    int num2 = array[j];
                    int num3 = array[k];
                    if (isTrianglePoosible(num1, num2, num3)) {
                        triangles++;
                    }
                    k++;
                }
                j++;
            }
        }
        return triangles;
    }

    private boolean isTrianglePoosible(int num1, int num2, int num3) {
        int[] sorted = {num1, num2, num3};
        Arrays.sort(sorted);
        return sorted[0] + sorted[1] > sorted[2];
    }


    public int findDistanceBetween(int num1, int num2, int[] array) {

        int num1Index = 0;
        boolean num1Found = false;
        while (!num1Found && (num1Index < array.length)) {
            if (array[num1Index] == num1) {
                num1Found = true;
            } else {
                num1Index++;
            }
        }
        if (!num1Found) return 0;

        int num2Index = num1Index + 1;
        boolean num2Found = false;
        while (!num2Found && num2Index < array.length) {
            if (array[num2Index] == num2) {
                num2Found = true;
            } else {
                num2Index++;
            }
        }
        if (!num2Found) return 0;

        return num2Index - num1Index;
    }


    int maxSumOfNoAdjacentElements(int[] arr) {
        return findMaxSumOfSubArrayWithNoAdjacentElements(arr, 0);
    }

    private int findMaxSumOfSubArrayWithNoAdjacentElements(int[] arr, int index) {
        if (index > arr.length - 1) return 0;
        if (index == arr.length - 1) return arr[index];

        int currentMax = arr[index] + findMaxSumOfSubArrayWithNoAdjacentElements(arr, index + 2);
        int adjacentMax = findMaxSumOfSubArrayWithNoAdjacentElements(arr, index + 1);
        return Math.max(currentMax, adjacentMax);

    }


}
