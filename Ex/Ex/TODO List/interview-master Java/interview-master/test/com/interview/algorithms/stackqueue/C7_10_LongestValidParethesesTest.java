package com.interview.algorithms.stackqueue;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-8
 * Time: 下午4:15
 */
public class C7_10_LongestValidParethesesTest extends TestCase {
    public void testLongestValidParentheses() throws Exception {
        String len = C7_10_LongestValidParetheses.longestValidParentheses(")()())()()(");
        assertEquals("()()", len);

        len = C7_10_LongestValidParetheses.longestValidParentheses("(()()");
        assertEquals("()()", len);

        len = C7_10_LongestValidParetheses.longestValidParentheses("(()())");
        assertEquals("(()())", len);

        len = C7_10_LongestValidParetheses.longestValidParentheses("()(()");
        assertEquals("()", len);

        len = C7_10_LongestValidParetheses.longestValidParentheses("()(())");
        assertEquals("()(())", len);

        len = C7_10_LongestValidParetheses.longestValidParentheses("()((())");
        assertEquals("(())", len);

        len = C7_10_LongestValidParetheses.longestValidParentheses("(()(((()");
        assertEquals("()", len);

        len = C7_10_LongestValidParetheses.longestValidParentheses(")(((((()())()()))()(()))(");
        //System.out.println(len);
        assertEquals("((((()())()()))()(()))", len);
    }
}
