package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_56_StationDistanceTest extends TestCase {

    public void testDistance() throws Exception {
        int[] distance = new int[]{1,2,3,4,5,6,7};
        C1_56_StationDistance dist = new C1_56_StationDistance(distance);

        assertEquals(7, dist.distance(1,3));
        assertEquals(9, dist.distance(4,2));
        assertEquals(1, dist.distance(6,0));
        assertEquals(-1, dist.distance(11,0));
        assertEquals(14, dist.distance(0,4));

    }
}