package com.interview.algorithms.dp;

import junit.framework.TestCase;
import org.testng.Assert;

/**
 * Created_By: stefanie
 * Date: 14-6-26
 * Time: 下午8:15
 */
public class C12_18_FastAssemblyLineTest extends TestCase {
    public void testFind() throws Exception {
        int[][] lines = new int[][]{{9,9,3,4,8,7},{12,5,6,4,5,9}};
        int[][][] transition = new int[2][2][];
        transition[0][1] = new int[] {0,2,3,1,3,4};
        transition[1][0] = new int[] {0,2,1,2,2,1};

        int[] solution = C12_18_FastAssemblyLine.find(lines, transition);

        int[] answer = {0,1,0,1,1,0};
        for(int i = 0; i < answer.length; i ++)
            Assert.assertEquals(solution[i], answer[i], "The " + i + "th row is wrong");

    }
}
