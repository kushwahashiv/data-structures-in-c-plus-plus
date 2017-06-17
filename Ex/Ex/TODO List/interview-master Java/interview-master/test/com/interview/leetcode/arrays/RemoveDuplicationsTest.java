package com.interview.leetcode.arrays;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-15
 * Time: 上午10:26
 */
public class RemoveDuplicationsTest extends TestCase {
    public void testRemoveMoreThanKTime() throws Exception {
        int[] num = new int[]{1,1,1,2,2,3};
        int[] expected = new int[]{1,2,3};
        int length = RemoveDuplications.removeMoreThanKTime(num, 1);
        for(int i = 0; i < length; i++) assertEquals(expected[i], num[i]);


        num = new int[]{1,1,1,2,2,3};
        expected = new int[]{1,1,2,2,3};
        length = RemoveDuplications.removeMoreThanKTime(num, 2);
        for(int i = 0; i < length; i++) assertEquals(expected[i], num[i]);
    }

    public void testRemoveDuplicates() throws Exception {
        int[] num = new int[]{1,1,2,3,3,4};
        int[] expected = new int[]{2,4};
        int length = RemoveDuplications.deduplicate(num);
        for(int i = 0; i < length; i++) assertEquals(expected[i], num[i]);
    }
}
