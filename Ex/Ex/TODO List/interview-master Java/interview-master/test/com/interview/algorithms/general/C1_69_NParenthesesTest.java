package com.interview.algorithms.general;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-10-26
 * Time: 下午6:32
 */
public class C1_69_NParenthesesTest extends TestCase {
    public void test1() throws Exception {
        List<String> sol = C1_69_NParentheses.find(3);
        assertEquals(5, sol.size());
        ConsoleWriter.printCollection(sol);
    }

    public void test2() throws Exception {
        List<String> sol = C1_69_NParentheses.find(4);
        assertEquals(14, sol.size());
        ConsoleWriter.printCollection(sol);
    }
}
