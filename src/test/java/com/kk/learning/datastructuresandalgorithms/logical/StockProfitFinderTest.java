package com.kk.learning.datastructuresandalgorithms.logical;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StockProfitFinderTest {

    @Test
    public void shouldReturnSellAndBuyDaysForGivenProfits() {
        int[] dailyProfits = {100, 180, 260, 310, 40, 535, 695};
        StockProfitFinder stockProfitFinder = new StockProfitFinder();
        List<Integer> daysForMaxProfit = stockProfitFinder.getDaysForMaxProfit(dailyProfits);
        System.out.println(daysForMaxProfit);
        assertEquals(Arrays.asList(4,6,0,3), daysForMaxProfit);
    }
}