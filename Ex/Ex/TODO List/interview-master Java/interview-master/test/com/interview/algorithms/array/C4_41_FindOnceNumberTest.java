package com.interview.algorithms.array;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-29
 * Time: 下午10:40
 */
public class C4_41_FindOnceNumberTest extends TestCase {
    public void testFind() throws Exception {
        int[] array = new int[] {1,2,3,4,5,6,2,3,4,5};
        Result r = C4_41_FindOnceNumber.find(array);
        assertTrue((r.n1 == 1 && r.n2 == 6) || (r.n1 == 6 && r.n2 == 1));
    }

    public void testcase2() throws Exception {
        int[] array = new int[] {1,6,3,4,5,2,1,3,6,5};
        Result r = C4_41_FindOnceNumber.find(array);
        assertTrue((r.n1 == 2 && r.n2 == 4) || (r.n1 == 4 && r.n2 == 2));
    }
}
