package com.interview.algorithms.general;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-4
 * Time: 下午4:33
 */
public class C1_53_HorseRacingTest extends TestCase {
    public void testTop5() throws Exception {
        Integer[] horses = TestUtil.generateIntArray(25, 100, 1);
        ConsoleWriter.printIntArray(horses);

        Integer[] top5 = C1_53_HorseRacing.top5(horses);
        ConsoleWriter.printIntArray(top5);

        C1_53_HorseRacing.sort(horses);
        ConsoleWriter.printIntArray(horses);

        for(int i = 0; i < 5; i++)
            assertEquals(horses[24-i], top5[i]);
    }
}
