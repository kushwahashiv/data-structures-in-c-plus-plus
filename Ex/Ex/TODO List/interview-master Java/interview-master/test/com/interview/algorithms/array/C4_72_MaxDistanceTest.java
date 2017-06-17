package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-31
 * Time: 下午10:12
 */
public class C4_72_MaxDistanceTest extends TestCase {
    public void testFind() throws Exception {
        int[] array = new int[]{4,3,5,2,1,3,2,3};
        ConsoleWriter.printIntArray(array);
        C4_73_MaxDistance.Pair pair = C4_73_MaxDistance.find(array);
        assertEquals(3, pair.start);
        assertEquals(7, pair.end);
        assertEquals(4, pair.dist);
    }

    public void testFind2() throws Exception {
        int[] array = new int[]{4,3,5,2,1,3,2,3};
        ConsoleWriter.printIntArray(array);
        C4_73_MaxDistance.Pair pair = C4_73_MaxDistance.findO2(array);
        assertEquals(3, pair.start);
        assertEquals(7, pair.end);
        assertEquals(4, pair.dist);
    }
}
