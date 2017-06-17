package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 下午5:39
 */
public class C4_32B_UniqueTripleSumKTest extends TestCase {
    public void testThreeSum() throws Exception {
        int[] num = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> sols = C4_32B_UniqueTripleSumK.threeSum(num);
        assertEquals(2, sols.size());
        ConsoleWriter.print(sols);
    }
}
