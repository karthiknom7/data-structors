package com.kk.learning.datastructuresandalgorithms.logical.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ShrinkArrayTest {

    @Test
    public void getShrunkArray() {

        List<String> inArr = Arrays.asList("a","a","b", "c","c", "c","d");
        List<String> shrunkArray = ShrinkArray.getShrunkArray(inArr, 3);
        assertEquals(Arrays.asList("a","a","b","d"), shrunkArray);
    }

    @Test
    public void getShrunkArray2() {

        List<String> inArr = Arrays.asList("a","a","b", "c","c", "c","d");
        List<String> shrunkArray = ShrinkArray.getShrunkArray(inArr, 2);
        assertEquals(Arrays.asList("b","d"), shrunkArray);
    }

    @Test
    public void getShrunkArray3() {

        List<String> inArr = Arrays.asList("a","b", "c","b");
        List<String> shrunkArray = ShrinkArray.getShrunkArray(inArr, 2);
        assertEquals(inArr, shrunkArray);
    }
}