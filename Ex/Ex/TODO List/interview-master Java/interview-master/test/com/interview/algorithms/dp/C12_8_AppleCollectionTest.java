package com.interview.algorithms.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 4/1/14
 * Time: 3:48 PM
 */
public class C12_8_AppleCollectionTest {

    @Test
    public void testAppleCollection() {
        int[][] table = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        } ;

        C12_8_AppleCollection test = new C12_8_AppleCollection();
        Assert.assertEquals(test.maxNumberOfApples(table), 73);
    }
}
