package com.kk.learning.datastructuresandalgorithms.alorithms.dynamicprograming;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciSeriesTest {

    private FibonacciSeries fibonacciSeries = new FibonacciSeries();

    @Test
    public void findFibonacciWithTopdownApproach() {

        int fibonacciWithTopdownApproach = fibonacciSeries.findFibonacciWithTopDownApproach(6);
        assertEquals(8, fibonacciWithTopdownApproach);
    }

    @Test
    public void findFibonacciWithBottomUpApproach() {

        int fibonacciWithBottomUpApproach = fibonacciSeries.findFibonacciWithBottomUpApproach(6);
        assertEquals(8, fibonacciWithBottomUpApproach);
    }
}