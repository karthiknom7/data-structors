package com.kk.learning.datastructuresandalgorithms.logical;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckAnagramsTest {

    private CheckAnagrams checkAnagrams = new CheckAnagrams();

    @Test
    public void shouldCheckForAnagrams() {
        assertTrue(checkAnagrams.isAnagrams("spar", "rasp"));
    }
}