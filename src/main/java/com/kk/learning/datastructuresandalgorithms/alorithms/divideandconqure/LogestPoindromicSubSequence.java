package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

public class LogestPoindromicSubSequence {

    public String findLongestPolindromicSubSequence(String s1, int startIndex, int endIndex) {

        if (startIndex > endIndex) return "";
        if (startIndex == endIndex) return s1.substring(startIndex, startIndex + 1);

        String equalProbabilityStr = "";
        String startProbability = "";
        String endProbability = "";
        if (s1.charAt(startIndex) == s1.charAt(endIndex)) {
            equalProbabilityStr = s1.substring(startIndex, startIndex + 1)
                    + findLongestPolindromicSubSequence(s1, startIndex + 1, endIndex - 1)
                    + s1.substring(endIndex, endIndex + 1);
        } else {
            startProbability = findLongestPolindromicSubSequence(s1, startIndex, endIndex - 1);
            endProbability = findLongestPolindromicSubSequence(s1, startIndex + 1, endIndex);
        }

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
