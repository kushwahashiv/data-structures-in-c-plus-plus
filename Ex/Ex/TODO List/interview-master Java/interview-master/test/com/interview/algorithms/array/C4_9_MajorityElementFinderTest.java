package com.interview.algorithms.array;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-8-5
 * Time: 下午2:41
 */
public class C4_9_MajorityElementFinderTest extends TestCase {
    Integer[] numbers = new Integer[]{5,5,2,5,5,2,4,5,5,5,1,1,1};

    public void testFind() throws Exception {
        assertEquals(5, C4_9_MajorityElementFinder.find(numbers));
    }

    public void testFind2(){
        List<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i < numbers.length; i++) array.add(numbers[i]);
        assertEquals(5, C4_9_MajorityElementFinder.find(array).intValue());
    }
}
