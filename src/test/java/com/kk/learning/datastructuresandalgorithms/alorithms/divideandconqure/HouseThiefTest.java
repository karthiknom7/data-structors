package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseThiefTest {

    @Test
    public void shouldStealMaxWorthFromAdjacentHouses() {
        int[] houses = {6,7,1,30,8,2,4};
        HouseThief houseThief = new HouseThief();
        int stealMaxWorth = houseThief.stealMaxWorth(houses, 0);
        assertEquals(41, stealMaxWorth);
    }

    @Test
    public void shouldStealMaxWorthFromAdjacentHousesWithTopDownApproach() {
        int[] houses = {6,7,1,30,8,2,4};
        HouseThief houseThief = new HouseThief();
        int stealMaxWorth = houseThief.stealMaxWorthWithTopDownApproach(houses, 0);
        assertEquals(41, stealMaxWorth);
    }

    @Test
    public void shouldStealMaxWorthFromAdjacentHousesWithBottomUpApproach() {
        int[] houses = {6,7,1,30,8,2,4};
        HouseThief houseThief = new HouseThief();
        int stealMaxWorth = houseThief.stealMaxWorthWithBottomUpApproach(houses, 0);
        assertEquals(41, stealMaxWorth);
    }
}