package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

public class LongestPolindromSubString {

    public String findLongestPolindromicSubString(String s1, int startIndex, int endIndex) {
        if (startIndex > endIndex) return "";
        if (startIndex == endIndex) return s1.substring(startIndex, startIndex + 1);

        String equalProbabilityStr = "";
        String startProbability = "";
        String endProbability = "";
        if (s1.charAt(startIndex) == s1.charAt(endIndex)) {
            String longestPolindromicSubString = findLongestPolindromicSubString(s1, startIndex + 1, endIndex - 1);
            if (longestPolindromicSubString.length() == (endIndex - startIndex - 1)) {
                equalProbabilityStr = s1.substring(startIndex, startIndex + 1)
                        + longestPolindromicSubString
                        + s1.substring(endIndex, endIndex + 1);
            } else endProbability = longestPolindromicSubString;
        }
        startProbability = findLongestPolindromicSubString(s1, startIndex, endIndex - 1);
        endProbability = findLongestPolindromicSubString(s1, startIndex + 1, endIndex);

        int equalLen = equalProbabilityStr.length();
        int startLen = startProbability.length();
        int endLen = endProbability.length();
        if (equalLen > startLen && equalLen > endLen) {
            return equalProbabilityStr;
        } else if (startLen > endLen) {
            return startProbability;
        } else {
            return endProbability;
        }
    }

}
