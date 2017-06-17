package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-19
 * Time: 下午6:21
 */
public class C4_46_ArithmeticProgressionFinderTest extends TestCase {

    public void testcase1(){
        Integer[] array = new Integer[]{1,3,0,5,-1,6};
        Integer[] progression = C4_46_ArithmeticProgressionFinder.find(array);
        ConsoleWriter.printIntArray(progression);
        Integer[] answers = new Integer[] {-1,1,3,5};
        for(int i = 0; i < answers.length; i++)
            assertEquals(answers[i], progression[i]);
    }

    public void testcase2(){
        Integer[] array = new Integer[]{1,3,0,4,-1,6};
        Integer[] progression = C4_46_ArithmeticProgressionFinder.find(array);
        assertNull(progression);
    }
}
