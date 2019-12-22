package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

public class HouseThief {

    public int stealMaxWorth(int[] houses, int currentHouse) {
        if (currentHouse < houses.length ) {

            int currentHouseWorth = houses[currentHouse] + stealMaxWorth(houses, currentHouse + 2);
            int nextHouseWorth = stealMaxWorth(houses, currentHouse + 1);
            return Math.max(currentHouseWorth, nextHouseWorth);
        } else {
            return 0;
        }
    }
}
