package com.interview.algorithms.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 3/24/14
 * Time: 3:39 PM
 */
public class C12_5_ZigZagTest {

    @Test
    public void testLongestZigZag() {
        C12_5_ZigZag test = new C12_5_ZigZag();

        int[] array = new int[] { 1, 7, 4, 9, 2, 5 };
        Assert.assertEquals(test.longestZigZag(array), 6);

        array = new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
        Assert.assertEquals(test.longestZigZag(array), 7);

        array = new int[] { 44 };
        Assert.assertEquals(test.longestZigZag(array), 1);

        array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Assert.assertEquals(test.longestZigZag(array), 2);

        array = new int[] { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };
        Assert.assertEquals(test.longestZigZag(array), 8);

        array = new int[] { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, // 7 ok  812 ends    i = 9
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188, // 13 ok  568 ends    (i=19)
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908, // 21 ok 908 ends    (i=29)
                477, 245, 413, 109};
                //477, 245, 413, 109, 659, 401, 483, 308, 609, 120}; // 30 not ok
        Assert.assertEquals(test.longestZigZag(array), 24);

        array = new int[] { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
        Assert.assertEquals(test.longestZigZag(array), 36);

    }

    @Test
    public void testcase(){
        C12_5_ZigZag test = new C12_5_ZigZag();

        int[] array = new int[]{5, 3, 4, 8, 6, 2}; //{-2,-1,4,-2,-4} //{5,3,4,2} //{5,4,6,2}
        Assert.assertEquals(4, test.longestZigZag(array));
    }
}
