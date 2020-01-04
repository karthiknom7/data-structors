package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogestPolindromicSubSequenceTest {


    @Test
    public void shouldReturnLogestPolindromicSubSequence() {
        String s1 = "ABCBDEA";
        LogestPolindromicSubSequence logestPolindromicSubSequence = new LogestPolindromicSubSequence();

        String polindromicSubSequence = logestPolindromicSubSequence.findLongestPolindromicSubSequence(s1, 0, s1.length()-1);
        assertEquals("ABCBA", polindromicSubSequence);
    }

    @Test
    public void shouldReturnLogestPolindromicSubSequence2() {
        String s1 = "ELRMENMET";
        LogestPolindromicSubSequence logestPolindromicSubSequence = new LogestPolindromicSubSequence();

        String polindromicSubSequence = logestPolindromicSubSequence.findLongestPolindromicSubSequence(s1, 0, s1.length()-1);
        assertEquals("EMNME", polindromicSubSequence);
    }
}