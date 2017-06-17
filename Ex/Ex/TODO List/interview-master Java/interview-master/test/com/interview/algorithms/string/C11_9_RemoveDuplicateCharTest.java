package com.interview.algorithms.string;

import junit.framework.TestCase;

public class C11_9_RemoveDuplicateCharTest extends TestCase {
    C11_9_RemoveDuplicateChar remover = new C11_9_RemoveDuplicateChar();

    public void testcase1(){
        String str = "abscuhi";
        assertEquals("abscuhi", remover.cleanByScan(str.toCharArray()));
        assertEquals("abscuhi", remover.cleanByScanOnce(str.toCharArray()));
    }

    public void testcase2(){
        String str = "yuushiphoshuuni";
        assertEquals("yushipon", remover.cleanByScan(str.toCharArray()));
        assertEquals("yushipon", remover.cleanByScanOnce(str.toCharArray()));
    }

    public void testcase3(){
        assertEquals(null, remover.cleanByScan(null));
        assertEquals(null, remover.cleanByScanOnce(null));
    }

}