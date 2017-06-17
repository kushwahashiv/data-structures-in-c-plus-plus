package com.interview.algorithms.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 3/27/14
 * Time: 6:17 PM
 */
public class C12_7_FlowerGardenTest {

    @Test
    public void testOrdering() {

        C12_7_FlowerGarden test = new C12_7_FlowerGarden();

        int[] height = new int[] {5,4,3,2,1};
        int[] bloom = new int[] {1,1,1,1,1};
        int[] wilt = new int[] {365,365,365,365,365};
        int[] expected = new int[] { 1,  2,  3,  4,  5 };
        int[] actual = test.getOrdering(height, bloom, wilt);
        for(int i = 0; i < actual.length; i ++)
            Assert.assertEquals(actual[i], expected[i], "The " + i + "th row is wrong");


        height = new int[] {5,4,3,2,1};
        bloom = new int[] {1,5,10,15,20};
        wilt = new int[] {4,9,14,19,24};
        expected = new int[] { 5,  4,  3,  2,  1 };
        actual = test.getOrdering(height, bloom, wilt);
        for(int i = 0; i < actual.length; i ++)
            Assert.assertEquals(actual[i], expected[i], "The " + i + "th row is wrong");


        height = new int[] {5,4,3,2,1};
        bloom = new int[] {1,5,10,15,20} ;
        wilt = new int[] {5,10,15,20,25} ;
        expected = new int[] { 1,  2,  3,  4,  5 } ;
        actual = test.getOrdering(height, bloom, wilt);
        for(int i = 0; i < actual.length; i ++)
            Assert.assertEquals(actual[i], expected[i], "The " + i + "th row is wrong");


        height = new int[] {5,4,3,2,1};
        bloom = new int[] {1,5,10,15,20} ;
        wilt = new int[] {5,10,14,20,25} ;
        expected = new int[] { 3,  4,  5,  1,  2 } ;
        actual = test.getOrdering(height, bloom, wilt);
        for(int i = 0; i < actual.length; i ++)
            Assert.assertEquals(actual[i], expected[i], "The " + i + "th row is wrong");


        height = new int[] {1, 2, 3, 4, 5, 6};
        bloom = new int[] {1, 3, 1, 3, 1, 3} ;
        wilt = new int[] {2,4,2,4,2,4} ;
        expected = new int[] { 2,  4,  6,  1,  3,  5 } ;
        actual = test.getOrdering(height, bloom, wilt);
        for(int i = 0; i < actual.length; i ++)
            Assert.assertEquals(actual[i], expected[i], "The " + i + "th row is wrong");


        height = new int[] {3,2,5,4};
        bloom = new int[] {1,2,11,10};
        wilt = new int[] {4,3,12,13};
        expected = new int[] { 4,  5,  2,  3 };
        actual = test.getOrdering(height, bloom, wilt);
        for(int i = 0; i < actual.length; i ++)
            Assert.assertEquals(actual[i], expected[i], "The " + i + "th row is wrong");

    }
}
