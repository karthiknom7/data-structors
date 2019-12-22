package com.kk.learning.datastructuresandalgorithms.alorithms.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CoinChangeTest {

    private int[] coins ={1,2,5,10,20,50,100,500,1000};
    @Test
    public void shouldReturnNumberCoinsForGivenInput() {
        CoinChange coinChange = new CoinChange();
        List<Integer> change = coinChange.getChange(coins, 12);
        assertEquals(Arrays.asList(10,2), change);
    }
}