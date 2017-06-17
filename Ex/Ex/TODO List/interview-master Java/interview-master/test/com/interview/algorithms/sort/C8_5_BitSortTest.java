package com.interview.algorithms.sort;

import junit.framework.TestCase;
import org.testng.Assert;

/**
 * Created_By: stefanie
 * Date: 14-7-8
 * Time: 下午9:10
 */
public class C8_5_BitSortTest extends TestCase {
    public void testcase1(){
        int[] test = {5,6,12,67,23,89,8,4,34,25};
        int[] sorted = {4,5,6,8,12,23,25,34,67,89};
        int[] actural = C8_5_BitSort.sort(test);

        for(int i = 0; i < actural.length; i ++)
            Assert.assertEquals(actural[i], sorted[i], "The " + i + "th row is wrong");
    }
}
