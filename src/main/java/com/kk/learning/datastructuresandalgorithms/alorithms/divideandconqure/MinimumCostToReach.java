package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

public class MinimumCostToReach {

    public int findMinimumCost(int[][] cost, int row, int col){
        if(row ==0 && col ==0){
            return cost[0][0];
        }
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }
        int rightCost = findMinimumCost(cost, row-1, col);
        int downCost = findMinimumCost(cost, row, col-1);
        return cost[row][col]  + Integer.min(rightCost, downCost);
    }
}
