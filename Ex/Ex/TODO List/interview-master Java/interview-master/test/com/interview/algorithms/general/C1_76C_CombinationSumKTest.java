package com.interview.algorithms.general;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 下午10:14
 */
public class C1_76C_CombinationSumKTest extends TestCase {
    public void testWithDuplication(){
        int[] num = new int[]{1,2};
        List<List<Integer>> combinations = C1_76C_CombinationSumK.combinationSum(num, 3, true);
        assertEquals(2, combinations.size());
        ConsoleWriter.print(combinations);

        num = new int[]{1,2,1,2};
        combinations = C1_76C_CombinationSumK.combinationSum(num, 3, true);
        assertEquals(2, combinations.size());
        ConsoleWriter.print(combinations);
    }

    public void testWithoutDuplication(){
        int[] num = new int[]{1,2};
        List<List<Integer>> combinations = C1_76C_CombinationSumK.combinationSum(num, 3, false);
        assertEquals(1, combinations.size());
        ConsoleWriter.print(combinations);

        num = new int[]{1,2,1,2};
        combinations = C1_76C_CombinationSumK.combinationSum(num, 3, false);
        assertEquals(1, combinations.size());
        ConsoleWriter.print(combinations);
    }
}
