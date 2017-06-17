package com.interview.utils;

import junit.framework.TestCase;
import org.testng.Assert;

public class ArrayUtilTest extends TestCase {

    public void testSort() throws Exception {
        Integer[] numbers = new Integer[] {1,2,5,3,4,5};
        Integer[] sorted =  ArrayUtil.sort(numbers);
        Integer[] expected = new Integer[] {1,2,3,4,5,5};
        for(int i = 0; i < sorted.length; i ++)
            Assert.assertEquals(sorted[i], expected[i], "The " + i + "th row is wrong");
    }
}