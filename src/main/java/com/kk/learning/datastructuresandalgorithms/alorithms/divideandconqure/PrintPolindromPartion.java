package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PrintPolindromPartion {

    List<String> getPolindromPartions(String str, int startIndex, int endIndex) {
        if (startIndex > endIndex) return Collections.EMPTY_LIST;
        if (startIndex == endIndex) return Collections.singletonList(str.substring(startIndex, startIndex + 1));
        List<String> partitions = new ArrayList<>();
        if (str.charAt(startIndex) == str.charAt(endIndex)) {
            List<String> polindromPartions = getPolindromPartions(str, startIndex + 1, endIndex - 1);
            String commonChar = str.substring(startIndex, startIndex + 1);
            List<String> collect = polindromPartions.stream().map(eachStr -> commonChar + eachStr + commonChar).collect(Collectors.toList());
            partitions.addAll(collect);
            partitions.addAll(polindromPartions);
        } else {
            List<String> startProbability = getPolindromPartions(str, startIndex + 1, endIndex);
            List<String> endProbability = getPolindromPartions(str, startIndex, endIndex - 1);
            partitions.addAll(startProbability);
            partitions.addAll(endProbability);
        }
        return partitions;
    }

    List<String> getPolindromPartions(String str) {
        List<String> partitions = new ArrayList<>();
        for(int i=0; i < str.length()-1; i++){
            int j = i +1;
            while (j < str.length()){
                String substring = str.substring(i, j+1);
                if(isPolindrom(substring)){
                    partitions.add(substring);
                }
                j++;
            }
        }
        return partitions;
    }

    private boolean isPolindrom(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;
        while (end > start) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
