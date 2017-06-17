package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-27
 * Time: 下午10:53
 */
public class C11_35_LongestWordMadeOfOthersTest extends TestCase {
    public void testFind() throws Exception {
        String[] words = new String[]{"cat", "dog", "nana", "banana", "walk", "walker", "dognana", "dogwalkers"};
        String word = C11_35_LongestWordMadeOfOthers.find(words);
        System.out.println(word);
    }
}
