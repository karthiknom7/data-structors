package com.kk.learning.datastructuresandalgorithms.logical.array;

import java.util.*;

public class ShrinkArray {

    public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
        System.out.println(inputArray );
        System.out.println(burstLength );
        if(inputArray.isEmpty() || burstLength == 1) return Collections.EMPTY_LIST;

        Map<String, Integer> charsCountMap = new HashMap<>();
        Map<String, Boolean> sequentialMap = new HashMap<>();

        for(int index =0 ; index < inputArray.size() -1; index++){
            String currentChart = inputArray.get(index);
            if(inputArray.get(index).equals(inputArray.get(index+1))){
                sequentialMap.put(currentChart, true);
            }
            charsCountMap.put(currentChart, charsCountMap.getOrDefault(currentChart, 0)+1);
        }

        String lastChar = inputArray.get(inputArray.size()-1);
        charsCountMap.put(lastChar, charsCountMap.getOrDefault(lastChar, 0)+1);

        List<String> shrunkArray = new ArrayList<>();
        for(String eachChar: inputArray){
            Integer charCount = charsCountMap.get(eachChar);
            Boolean isSequentialChar = sequentialMap.getOrDefault(eachChar, false);
            if(charCount < burstLength || !isSequentialChar){
                shrunkArray.add(eachChar);
            }
        }
        return shrunkArray;
    }


    public static List<String> getShrunkArray2(List<String> inputArray, int burstLength) {
        System.out.println(inputArray );
        System.out.println(burstLength );
        if(inputArray.isEmpty() || burstLength == 1) return Collections.EMPTY_LIST;

        Map<String, Integer> charsCountMap = new HashMap<>();
        Map<String, Boolean> sequentialMap = new HashMap<>();

        for(int index =0 ; index < inputArray.size() -1; index++){
            String currentChart = inputArray.get(index);
            if(inputArray.get(index).equals(inputArray.get(index+1))){
                sequentialMap.put(currentChart, true);
            }
            charsCountMap.put(currentChart, charsCountMap.getOrDefault(currentChart, 0)+1);
        }

        String lastChar = inputArray.get(inputArray.size()-1);
        charsCountMap.put(lastChar, charsCountMap.getOrDefault(lastChar, 0)+1);

        List<String> shrunkArray = new ArrayList<>();
        for(String eachChar: inputArray){
            Integer charCount = charsCountMap.get(eachChar);
            Boolean isSequentialChar = sequentialMap.getOrDefault(eachChar, false);
            if(charCount < burstLength || !isSequentialChar){
                shrunkArray.add(eachChar);
            }
        }
        return shrunkArray;
    }
}
