package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

public class HouseThief {

    public int stealMaxWorth(int[] houses, int currentHouse) {
        if (currentHouse < houses.length) {

            int currentHouseWorth = houses[currentHouse] + stealMaxWorth(houses, currentHouse + 2);
            int nextHouseWorth = stealMaxWorth(houses, currentHouse + 1);
            return Math.max(currentHouseWorth, nextHouseWorth);
        } else {
            return 0;
        }
    }

    public int stealMaxWorthWithTopDownApproach(int[] houses, int currentHouse) {
        int[] prevResult = new int[houses.length];
        return withTopDownApproach(houses, prevResult, currentHouse);
    }

    private int withTopDownApproach(int[] houses, int[] previousResult, int currentHouse) {
        if (currentHouse >= houses.length) return 0;
        if (previousResult[currentHouse] == 0) {
            int currentHouseWorth = houses[currentHouse] + withTopDownApproach(houses, previousResult, currentHouse + 2);
            int nextToNextHouseWorth = withTopDownApproach(houses, previousResult, currentHouse + 1);
            previousResult[currentHouse] = Math.max(currentHouseWorth, nextToNextHouseWorth);
        }
        return previousResult[currentHouse];
    }

    public int stealMaxWorthWithBottomUpApproach(int[] houses, int currentHouse) {
        return withBottomUpApproach(houses, currentHouse);
    }

    private int withBottomUpApproach(int[] houses, int currentHouse) {
        int length = houses.length;
        int[] result = new int[length+2];
        result[result.length-1] = 0;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = Math.max(houses[i] + result[i + 2], result[i + 1]);
        }
        return Math.max(result[currentHouse], result[currentHouse + 1]);
    }
}
