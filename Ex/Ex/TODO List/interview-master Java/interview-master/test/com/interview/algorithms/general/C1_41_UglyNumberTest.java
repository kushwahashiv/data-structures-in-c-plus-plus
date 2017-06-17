package com.interview.algorithms.general;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-31
 * Time: 下午10:09
 */
public class C1_41_UglyNumberTest extends TestCase {
    public void testFind() throws Exception {
        int[] numbers = C1_42_UglyNumber.findNumber(15);
        ConsoleWriter.printIntArray(numbers);

        numbers = C1_42_UglyNumber.find(15);
        ConsoleWriter.printIntArray(numbers);
    }
}
