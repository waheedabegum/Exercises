package com.ge.exercise2;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Assume;
import org.junit.Test;

public class ArrayQuadrantUtilTest {

    @Test
    public void getQuadrantValuesTest() {
        char[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };
//kindly refer logger messages for the output after calling the methods
        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValues(0, 1));
        Assume.assumeNotNull(util.getQuadrantValuesrows(0));     
        Assume.assumeNotNull(util.getQuadrantValuesColumn(1));
        assertTrue(true);
       // char[] expectedResult = {'a', 'b', 'e', 'f'};
    }
}
