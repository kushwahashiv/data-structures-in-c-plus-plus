package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.Node;
import com.interview.util.TestUtil;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-19
 * Time: 上午12:36
 */
public class C3_14_ListCycleFinderTest extends TestCase {
    public void testHasCycle() throws Exception {
        LinkedList list = TestUtil.generateLinkedList(10);
        Node hasCycle = C3_14_ListCycleFinder.hasCycle(list);
        assertNull(hasCycle);
    }

    public void testNotHasCycle() throws Exception {
        LinkedList list = TestUtil.generateCycleLinkedList(10);
        Node hasCycle = C3_14_ListCycleFinder.hasCycle(list);
        assertNotNull(hasCycle);
    }
}
