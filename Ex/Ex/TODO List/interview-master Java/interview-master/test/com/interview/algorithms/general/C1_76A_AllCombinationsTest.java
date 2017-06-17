package com.interview.algorithms.general;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 下午3:55
 */
public class C1_76A_AllCombinationsTest extends TestCase {
    public void testCombine() throws Exception {
        List<List<Integer>> combinations = C1_76A_AllCombinations.combine(4);
        //ConsoleWriter.print(combinations);
        assertEquals(15, combinations.size());
    }
}
