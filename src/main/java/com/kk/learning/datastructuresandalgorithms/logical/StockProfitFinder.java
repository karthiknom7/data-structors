package com.kk.learning.datastructuresandalgorithms.logical;

import java.util.*;

public class StockProfitFinder {

    List<Integer> getDaysForMaxProfit(int[] dailyStockRate) {

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < dailyStockRate.length; i++) {
            map.put(dailyStockRate[i], i);
        }

        Set<Integer> visitedIndex = new LinkedHashSet<>();
        List<Integer> days = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            boolean foundMax = false;
            int currentIndex = entry.getValue();
            if (!visitedIndex.contains(currentIndex)) {
                days.add(currentIndex);
                while (!foundMax && currentIndex < dailyStockRate.length) {
                    visitedIndex.add(currentIndex);
                    if (currentIndex == dailyStockRate.length - 1) {
                        if (dailyStockRate[currentIndex] > dailyStockRate[currentIndex - 1]) {
                            days.add(currentIndex);
                        }
                    } else if (dailyStockRate[currentIndex] > dailyStockRate[currentIndex + 1]) {
                        days.add(currentIndex);
                        foundMax = true;
                    }
                    currentIndex++;
                }
            }
        }
        return days;
    }
}
