package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-3
 * Time: 下午6:56
 */
public class C11_1_UniqueCharacterStringTest extends TestCase {
    C11_1_UniqueCharacterString checker = new C11_1_UniqueCharacterString();

    public void testcase1(){
        String str = "abcdefghijklmnopqrstuvwxyz";
        assertEquals(true, checker.check(str));

    }

    public void testcase2(){
        String str = "AabcdefghijkLmnoPpqrstuVwxyz";
        assertEquals(true, checker.check(str));
    }

    public void testcase3(){
        String str = "[AbcdefghijkLmnoPqrstu645Vwxyz:);]";
        assertEquals(true, checker.check(str));
    }

    public void testcase4(){
        String str = "sujpoubjwy72bbsj";
        assertEquals(false, checker.check(str));
    }

    public void testcase5(){
        String str = "abs:tring:762}}";
        assertEquals(false, checker.check(str));
    }

    public void testcase6(){
        String str = "7766699uahusi";
        assertEquals(false, checker.check(str));
    }
}
