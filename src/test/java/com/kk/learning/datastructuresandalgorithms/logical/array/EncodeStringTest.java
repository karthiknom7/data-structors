package com.kk.learning.datastructuresandalgorithms.logical.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncodeStringTest {

    @Test
    public void shouldEncodeTheString() {
        String ggggGrrrrt = EncodeString.collapseString("GGGGGrrrt");
        assertEquals("5G3r1t", ggggGrrrrt);
    }

    @Test
    public void shouldEncodeTheString2() {
        String ggggGrrrrt = EncodeString.collapseString("GGGGGrrrt111");
        assertEquals("5G3r1t31", ggggGrrrrt);
    }

    @Test
    public void shouldEncodeTheString3() {
        String ggggGrrrrt = EncodeString.collapseString("GGGttGGG");
        assertEquals("3G2t3G", ggggGrrrrt);
    }
}