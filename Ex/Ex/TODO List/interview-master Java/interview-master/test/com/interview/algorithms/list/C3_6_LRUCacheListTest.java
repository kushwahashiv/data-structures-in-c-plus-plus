package com.interview.algorithms.list;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-6-29
 * Time: 下午11:19
 */
public class C3_6_LRUCacheListTest extends TestCase {
    C3_6_LRUCacheList<String, String> list = new C3_6_LRUCacheList<String, String>(2);

    public void test() throws Exception {
        list.set("a", "1");
        assertEquals(1, list.size());
        list.set("b", "2");
        assertEquals(2, list.size());
        list.set("c", "3");
        assertEquals(2, list.size());
        assertEquals(null, list.get("a"));
        assertEquals("2", list.get("b"));
        assertEquals("3", list.get("c"));
        list.set("b", "4");
        list.set("d", "5");
        assertEquals(null, list.get("c"));
        assertEquals("4", list.get("b"));
    }
}
