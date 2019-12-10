package com.kk.learning.datastructuresandalgorithms.alorithms;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SortingAlgorithmsTest {

    private Logger log = LoggerFactory.getLogger(getClass());
    private int[] input;
    private final int[] expectedOutput = {1,3,4,5,6,7,9,10};

    @Before
    public void setUp() throws Exception {
        input = new int[]{9,6,7,5,4,3,1,10};
    }

    private SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

    @Test
    public void testBubbleSort() {
        int[] output = sortingAlgorithms.bubbleSort(input);
        log.info("Output : " + Arrays.toString(output));
        assertArrayEquals(expectedOutput, output);
    }


    @Test
    public void testSelectionSort() {
        int[] output = sortingAlgorithms.selectionSort(input);
        log.info("Output : " + Arrays.toString(output));
        assertArrayEquals(expectedOutput, output);
    }

    @Test
    public void testInsertionSort() {
        sortingAlgorithms.insertionSort(input);
        log.info("Output : " + Arrays.toString(input));
        assertArrayEquals(expectedOutput, input);
    }
}