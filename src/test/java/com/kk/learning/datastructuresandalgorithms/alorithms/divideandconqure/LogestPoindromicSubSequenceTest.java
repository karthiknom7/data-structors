package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogestPoindromicSubSequenceTest {


    @Test
    public void shouldReturnLogestPolindromicSubSequence() {
        String s1 = "ABCBDEA";
        LogestPoindromicSubSequence logestPoindromicSubSequence = new LogestPoindromicSubSequence();

        String polindromicSubSequence = logestPoindromicSubSequence.findLongestPolindromicSubSequence(s1, 0, s1.length()-1);
        assertEquals("ABCBA", polindromicSubSequence);
    }

    @Test
    public void shouldReturnLogestPolindromicSubSequence2() {
        String s1 = "ELRMENMET";
        LogestPoindromicSubSequence logestPoindromicSubSequence = new LogestPoindromicSubSequence();

        String polindromicSubSequence = logestPoindromicSubSequence.findLongestPolindromicSubSequence(s1, 0, s1.length()-1);
        assertEquals("EMNME", polindromicSubSequence);
    }
}