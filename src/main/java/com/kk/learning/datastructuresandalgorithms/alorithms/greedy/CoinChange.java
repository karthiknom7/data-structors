package com.kk.learning.datastructuresandalgorithms.alorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

    public List<Integer> getChange(int[] coins, int value) {
        List<Integer> change =new ArrayList<>();
        while (value >0){
            int maxDenomination = maxDenominationForValue(coins, value);
            change.add(maxDenomination);
            value = value - maxDenomination;
        }
        return change;
    }

    private int maxDenominationForValue(int[] coins, int value){
        for(int i = coins.length-1; i > 0; i--){
            if(coins[i] <= value){
                return coins[i];
            }
        }
        return 0;
    }
}
