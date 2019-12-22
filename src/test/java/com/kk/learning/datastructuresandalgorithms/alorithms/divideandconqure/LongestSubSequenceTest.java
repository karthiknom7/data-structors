package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubSequenceTest {

    @Test
    public void shouldReturnLogestSubSequence() {
        String s1 = "ABCDE";
        String s2 = "ACDEF";
        LongestSubSequence longestSubSequence = new LongestSubSequence();
        String subSequence = longestSubSequence.findLongestSubSequence(s1, s2, 0, 0);
        assertEquals("ACDE", subSequence);
    }
}