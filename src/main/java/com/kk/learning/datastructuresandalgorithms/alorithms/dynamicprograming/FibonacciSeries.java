package com.kk.learning.datastructuresandalgorithms.alorithms.dynamicprograming;

public class FibonacciSeries {

    public int findFibonacciWithTopDownApproach(int num) {
        int[] previousResult = new int[num + 1];
        return withTopDownApproac(previousResult, num);
    }

    private int withTopDownApproac(int[] previousResult, int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (previousResult[num] == 0) {
            int currentValue = withTopDownApproac(previousResult, num - 1) + withTopDownApproac(previousResult, num - 2);
            previousResult[num] = currentValue;
        }
        return previousResult[num];
    }

    public int findFibonacciWithBottomUpApproach(int num) {
        return withBottomUpApproach(num);
    }

    private int withBottomUpApproach(int num) {
        int[] previousResult = new int[num + 1];
        previousResult[0] = 0;
        previousResult[1] = 1;
        for (int i = 2; i <= num; i++) {
            previousResult[i] = previousResult[i - 1] + previousResult[i - 2];
        }
        return previousResult[num];
    }
}
