package com.interview.algorithms.dp;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-20
 * Time: 下午6:08
 */
public class C12_24_EditingDistanceTest extends TestCase {

    public void testcase1() throws Exception {
        int distance = C12_24_EditingDistance.distance("ab", "b");
        assertEquals(1, distance);
    }

    public void testcase2() throws Exception {
        int distance = C12_24_EditingDistance.distance("ab", "acb");
        assertEquals(1, distance);
    }

    public void testcase3() throws Exception {
        int distance = C12_24_EditingDistance.distance("ab", "ac");
        assertEquals(1, distance);
    }

    public void testcase4() throws Exception {
        int distance = C12_24_EditingDistance.distance("a", "bc");
        assertEquals(2, distance);
    }

    public void testcase5() throws Exception {
        int distance = C12_24_EditingDistance.distance("ab", "ab");
        assertEquals(0, distance);
    }

    public void testDistance() throws Exception {
        int distance = C12_24_EditingDistance.distance("stefanie", "summer");
        System.out.println(distance);
    }
}
