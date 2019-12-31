package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

import org.junit.Test;

import static org.junit.Assert.*;

public class EditsFinderTest {


    @Test
    public void shouldFindMinimunEditsRequiredToConvertString1ToString2Case1() {
        String s1 = "seek";
        String s2 = "seesks";
        EditsFinder editsFinder = new EditsFinder();
        int numberOdEdits = editsFinder.findNumberOfEdits(s1.toCharArray(), s2.toCharArray(), 0, 0);
        assertEquals(2, numberOdEdits);
    }

    @Test
    public void shouldFindMinimunEditsRequiredToConvertString1ToString2Case2() {
        String s1 = "sunday";
        String s2 = "saturday";
        EditsFinder editsFinder = new EditsFinder();
        int numberOdEdits = editsFinder.findNumberOfEdits(s1.toCharArray(), s2.toCharArray(), 0, 0);
        assertEquals(3, numberOdEdits);
    }
}