package com.kk.learning.datastructuresandalgorithms.alorithms.divideandconqure;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PrintPolindromPartionTest {

    @Test
    public void shouldReturnListOfPossiblePolindromPartitions() {

        PrintPolindromPartion printPolindromPartion = new PrintPolindromPartion();
        List<String> polindromPartions = printPolindromPartion.getPolindromPartions("MADAM", 0, 4);
        System.out.println(polindromPartions);
        assertEquals(7, polindromPartions.size());
    }


    @Test
    public void shouldReturnListOfPossiblePolindromPartitions2() {

        PrintPolindromPartion printPolindromPartion = new PrintPolindromPartion();
        List<String> polindromPartions = printPolindromPartion.getPolindromPartions("MADAM");
        System.out.println(polindromPartions);
        assertEquals(2, polindromPartions.size());
    }

    @Test
    public void shouldReturnListOfPossiblePolindromPartitions3() {

        PrintPolindromPartion printPolindromPartion = new PrintPolindromPartion();
        List<String> polindromPartions = printPolindromPartion.getPolindromPartions("seeks");
        System.out.println(polindromPartions);
        assertEquals(1, polindromPartions.size());
    }
}