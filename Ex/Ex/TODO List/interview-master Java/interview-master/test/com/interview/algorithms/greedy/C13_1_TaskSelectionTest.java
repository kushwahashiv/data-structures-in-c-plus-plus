package com.interview.algorithms.greedy;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-9-20
 * Time: 下午7:10
 */
public class C13_1_TaskSelectionTest extends TestCase {

    public void testSelect() throws Exception {
        int[] start = new int[]{1,3,0,5,3,5,6,8,8,2,12};
        int[] end   = new int[]{4,5,6,7,8,9,10,11,12,13,14};

        List<Integer> tasks = C13_1_TaskSelection.select(start, end);

        assertEquals(4, tasks.size());
        assertTrue(tasks.contains(1));
        assertTrue(tasks.contains(4));
        assertTrue(tasks.contains(8));
        assertTrue(tasks.contains(11));
    }
}
