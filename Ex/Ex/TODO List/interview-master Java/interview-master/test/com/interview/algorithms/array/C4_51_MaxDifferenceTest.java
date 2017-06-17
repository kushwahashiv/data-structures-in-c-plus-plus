package com.interview.algorithms.array;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-9-4
 * Time: 下午4:01
 */
public class C4_51_MaxDifferenceTest extends TestCase {
    public void testFind() throws Exception {
        Integer[] numbers = TestUtil.generateIntArray(10, 100, 0);
        ConsoleWriter.printIntArray(numbers);
        int maxDifference = C4_51_MaxDifference.find(numbers);
        int answer = C4_51_MaxDifference.correctAnswer(numbers);
        assertEquals(answer, maxDifference);

    }
}
