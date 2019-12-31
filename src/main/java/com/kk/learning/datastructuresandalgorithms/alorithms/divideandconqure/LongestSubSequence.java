package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

public class LongestSubSequence {

    public String findLongestSubSequence(String s1, String s2, int charAtS1, int charAtS2) {

        if(charAtS1== s1.length() || charAtS2 == s2.length()){
            return "";
        }
        String equalChar = "";
        String removingFromS1Char = "";
        String removingFromS2Char = "";
        if (s1.charAt(charAtS1) == s2.charAt(charAtS2)) {
            equalChar = s1.substring(charAtS1, charAtS1 + 1) + findLongestSubSequence(s1, s2, charAtS1 + 1, charAtS2 + 1);
        }else {
            removingFromS2Char = findLongestSubSequence(s1, s2, charAtS1, charAtS2 + 1);
            removingFromS1Char = findLongestSubSequence(s1, s2, charAtS1 + 1, charAtS2);
        }

        if (equalChar.length() > removingFromS1Char.length() && equalChar.length() > removingFromS2Char.length()) {
            return equalChar;
        } else if (removingFromS1Char.length() > removingFromS2Char.length()) {
            return removingFromS1Char;
        } else {
            return removingFromS2Char;
        }

    }

}
