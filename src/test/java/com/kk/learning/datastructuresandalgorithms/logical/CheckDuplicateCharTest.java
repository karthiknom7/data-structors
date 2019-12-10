package com.kk.learning.datastructuresandalgorithms.logical;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckDuplicateCharTest {


    private CheckDuplicateChar checkDuplicateChar = new CheckDuplicateChar();
    @Test
    public void shouldFindIfStringHAsDuplicateStrings() {
        String input = "hello";
        assertTrue(checkDuplicateChar.hasDuplicateChar(input));
        assertTrue(checkDuplicateChar.hasDuplicateChar("kill"));
        assertFalse(checkDuplicateChar.hasDuplicateChar("phone"));

    }
}