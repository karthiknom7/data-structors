package com.kk.learning.datastructuresandalgorithms.logical.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayProblemsTest {

    ArrayProblems arrayProblems = new ArrayProblems();
    private int[] input;

    @Before
    public void setUp() throws Exception {
        input = new int[]{12, 35, 35, 1, 10, 34, 1};
    }

    @Test
    public void shouldFindSecondLargestInArray() {
        int secondLargest = arrayProblems.findSecondLargest(input);
        assertEquals(34, secondLargest);
    }

    @Test
    public void shouldReaverseAnArray() {
        int[] expected = {1, 34, 10, 1, 35, 35, 12};
        arrayProblems.reverseArray(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void shouldRotateArrayByGivenNumberOfTimes() {
        int[] expected = {1, 10, 34, 1, 12, 35, 35};
        arrayProblems.rotateArrayBy(3, input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void shouldRemoveDuplicates() {
        input = new int[]{2,2,3,4,5,5};
        int[] expected ={2,3,4,5};
        int[] output = arrayProblems.removeDuplicates(input);
        assertArrayEquals(expected, output);
    }


    @Test
    public void shouldReturnNumberOfPossibleTriangles() {
        input = new int[]{4,6,3,7};
        int numberOfpossibleTriangles = arrayProblems.numberOfpossibleTriangles(input);
        assertEquals(3, numberOfpossibleTriangles );
    }

    @Test
    public void shouldReturnNumberOfPossibleTrianglesAnotherArray() {
        input = new int[]{10, 21, 22, 100, 101, 200, 300};
        int numberOfpossibleTriangles = arrayProblems.numberOfpossibleTriangles(input);
        assertEquals(6, numberOfpossibleTriangles );
    }

    @Test
    public void shouldReturnFindDistanceBetweenGivenNumbers() {
        input = new int[]{3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        int distanceBetween = arrayProblems.findDistanceBetween(3, 6,input);
        assertEquals(4, distanceBetween );
    }

    @Test
    public void shouldMaxSumOfSubArrayNotConsiderAdjacentElements() {
        input = new int[]{5, 5, 10, 100, 10, 5};
        int maxSumOfNoAdjacentElemets = arrayProblems.maxSumOfNoAdjacentElements(input);
        assertEquals(110, maxSumOfNoAdjacentElemets );
    }

    @Test
    public void shouldMaxSumOfSubArrayNotConsiderAdjacentElements2() {
        input = new int[]{1,2,3};
        int maxSumOfNoAdjacentElemets = arrayProblems.maxSumOfNoAdjacentElements(input);
        assertEquals(4, maxSumOfNoAdjacentElemets );
    }

    @Test
    public void shouldMaxSumOfSubArrayNotConsiderAdjacentElements3() {
        input = new int[]{1,20,3};
        int maxSumOfNoAdjacentElemets = arrayProblems.maxSumOfNoAdjacentElements(input);
        assertEquals(20, maxSumOfNoAdjacentElemets );
    }

    @Test
    public void shouldConvertGivenArrayToZigZgaFashion() {
        input = new int[]{4, 3, 7, 8, 6, 2, 1};
        int[] expected = new int[]{3, 7, 4, 8, 2, 6, 1};
        arrayProblems.convertToZigZagArray(input);
        assertArrayEquals(expected, input);
    }



    @Test
    public void shouldReturnMaxLengthOfSubArray1() {
        input = new int[] {10, 12, 11};
        int lengthOfMaxSubArray = arrayProblems.findLengthOfMaxSubArray(input);
        assertEquals(2, lengthOfMaxSubArray);
    }

    @Test
    public void shouldReturnMaxLengthOfSubArray2() {
        input = new int[] {14, 12, 11, 20};
        int lengthOfMaxSubArray = arrayProblems.findLengthOfMaxSubArray(input);
        assertEquals(2, lengthOfMaxSubArray);
    }
    @Test
    public void shouldReturnMaxLengthOfSubArray3() {
        input = new int[] {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        int lengthOfMaxSubArray = arrayProblems.findLengthOfMaxSubArray(input);
        assertEquals(4, lengthOfMaxSubArray);
    }
}