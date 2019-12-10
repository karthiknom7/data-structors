package com.kk.learning.datastructuresandalgorithms.datastructures.array;

import org.junit.Assert;
import org.junit.Test;

public class CustomArrayListTest {


    @Test
    public void shouldInsertElementToSpecificIndex() {
        Integer[] elements = {1, 2, 3, 4};
        Integer[] expectedElements = {1, 9, 2, 3, 4};

        CustomArrayList customArrayList = new CustomArrayList<Integer>(elements);
        customArrayList.add(1, 9);
        Object[] allElements = customArrayList.getAllElements();
        Assert.assertEquals(expectedElements, allElements);


    }

    @Test
    public void shouldInitializeWithElemetsPassed() {
        Integer[] elements = {1, 2, 3, 4};
        CustomArrayList customArrayList = new CustomArrayList<Integer>(elements);
        Object[] allElements = customArrayList.getAllElements();
        Assert.assertEquals(allElements, elements);

    }
}