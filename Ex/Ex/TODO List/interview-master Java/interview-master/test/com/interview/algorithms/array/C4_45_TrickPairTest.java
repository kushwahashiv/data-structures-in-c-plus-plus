package com.interview.algorithms.array;

import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-19
 * Time: 下午3:46
 */
public class C4_45_TrickPairTest extends TestCase {

    public void testcase1(){
        Integer[] array = new Integer[]{1,2,3,4,5,6,7};
        assertEquals(0, C4_45_TrickPair.find(array));
        assertEquals(0, C4_45_TrickPair.findByMerge(array));
    }

    public void testcase2(){
        Integer[] array = new Integer[]{1,2,8,4,5,6,7};
        assertEquals(4, C4_45_TrickPair.find(array));
        assertEquals(4, C4_45_TrickPair.findByMerge(array));
    }

    public void testcase3(){
        Integer[] array = new Integer[]{56, 64, 100, 29, 31, 26, 3, 80, 83, 26};
        assertEquals(26, C4_45_TrickPair.find(array));
        assertEquals(26, C4_45_TrickPair.findByMerge(array));
    }
}
