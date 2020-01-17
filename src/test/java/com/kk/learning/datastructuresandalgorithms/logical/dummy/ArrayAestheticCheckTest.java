package com.kk.learning.datastructuresandalgorithms.logical.dummy;

import com.kk.learning.datastructuresandalgorithms.logical.array.ArrayAestheticCheck;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayAestheticCheckTest {

    @Test
    public void shouldReturnAesthetic() {
        ArrayAestheticCheck arrayAestheticCheck = new ArrayAestheticCheck();
        int[] input = {3, 4, 5, 3, 7};
        int solution1 = arrayAestheticCheck.solution(input);
        assertEquals(3, solution1);
    }

    @Test
    public void shouldReturnAesthetic1() {
        ArrayAestheticCheck arrayAestheticCheck = new ArrayAestheticCheck();
        int[] input = {1, 3, 1, 2, 3};
        boolean aesthetic = arrayAestheticCheck.isAesthetic(input, 4);
        assertTrue(aesthetic);

    }

    @Test
    public void shouldReturnAesthetic2() {
        ArrayAestheticCheck arrayAestheticCheck = new ArrayAestheticCheck();
        int[] input = {1, 3, 3, 1, 2};
        boolean aesthetic = arrayAestheticCheck.isAesthetic(input, 2);
        assertTrue(aesthetic);

    }

    @Test
    public void shouldReturnAesthetic3() {
        ArrayAestheticCheck arrayAestheticCheck = new ArrayAestheticCheck();
        int[] input = {3, 1, 3, 1, 2};
        boolean aesthetic = arrayAestheticCheck.isAesthetic(input, 0);
        assertTrue(aesthetic);

    }

    @Test
    public void shouldReturnAesthetic4() {
        ArrayAestheticCheck arrayAestheticCheck = new ArrayAestheticCheck();
        int[] input = {4, 3, 4, 2, 1};
        boolean aesthetic = arrayAestheticCheck.isAesthetic(input, 4);
        assertTrue(aesthetic);

    }

    @Test
    public void shouldReturnAesthetic5() {
        ArrayAestheticCheck arrayAestheticCheck = new ArrayAestheticCheck();
        int[] input = {4, 3, 3, 4, 2};
        boolean aesthetic = arrayAestheticCheck.isAesthetic(input, 0);
        assertFalse(aesthetic);

    }

    @Test
    public void shouldReturnAesthetic6() {
        ArrayAestheticCheck arrayAestheticCheck = new ArrayAestheticCheck();
        int[] input = {3, 1, 3, 1, 2};
        boolean aesthetic = arrayAestheticCheck.isAesthetic(input, 0);
        assertTrue(aesthetic);

    }

    @Test
    public void shouldReturnAesthetic7() {
        ArrayAestheticCheck arrayAestheticCheck = new ArrayAestheticCheck();
        int[] input = {1, 2, 3, 4};
        boolean aesthetic = arrayAestheticCheck.isAesthetic(input, 0);
        assertFalse(aesthetic);

    }

}