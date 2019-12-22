package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPolindromSubStringTest {

    @Test
    public void shouldReturnLogestPolindromicSubString() {
        String s1 = "ABCBADEA";
        LongestPolindromSubString longestPolindromSubString = new LongestPolindromSubString();

        String polindromicSubSequence = longestPolindromSubString.findLongestPolindromicSubString(s1, 0, s1.length() - 1);
        assertEquals("ABCBA", polindromicSubSequence);
    }


}