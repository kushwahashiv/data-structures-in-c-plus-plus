package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-19
 * Time: 上午9:47
 */
public class C11_31_AnagramSortTest extends TestCase {
    public void testSort() throws Exception {
        String[] array = new String[]{"yoshi", "eat", "shyoi", "army", "tea", "yshio", "mary", "yarm", "abc", "bac"};
        C11_31_AnagramSort.sort(array);
        for(int i = 0; i < array.length; i++) System.out.println(array[i]);
    }
}
