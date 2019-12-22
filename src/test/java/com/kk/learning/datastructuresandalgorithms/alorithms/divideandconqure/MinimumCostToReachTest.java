package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumCostToReachTest {

    @Test
    public void shouldFindMinimumCostToReachLastElementsOfArray() {

        int[][] costs= {{2,3,4},
                        {4,5,6},
                        {4,3,2}};
        MinimumCostToReach minimumCostToReach = new MinimumCostToReach();
        int minimumCost = minimumCostToReach.findMinimumCost(costs, 2, 2);
        assertEquals(15, minimumCost);
    }
}