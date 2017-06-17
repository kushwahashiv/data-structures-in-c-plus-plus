package com.interview.basics.model.collection;

import com.interview.basics.model.collection.hash.HashSet;
import com.interview.basics.model.collection.hash.Set;
import junit.framework.TestCase;

import java.util.Iterator;

public class SetTest extends TestCase {
    Set<Integer> set;
    @Override
    public void setUp() throws Exception {
        set = new HashSet<Integer>();
    }

    public void testAdd() throws Exception {
        set.add(1);
        assertEquals(1, set.size());
        set.add(1);
        assertEquals(1, set.size());
        set.add(2);
        assertEquals(2, set.size());
    }

    public void testContains() throws Exception {
        set.add(1);
        assertEquals(true, set.contains(1));
        assertEquals(false, set.contains(3));
    }

    public void testRemove() throws Exception {
        set.add(1);
        assertEquals(1, set.size());
        set.remove(1);
        assertEquals(0, set.size());
    }

    public void testSize() throws Exception {
        assertEquals(0, set.size());
        set.add(1);
        assertEquals(1, set.size());
    }

    public void testIsEmpty() throws Exception {
        assertEquals(true, set.isEmpty());
        set.add(1);
        assertEquals(false, set.isEmpty());
    }

    public void testIterator(){
        set.add(1);
        set.add(2);
        Iterator<Integer> itr = set.iterator();
        assertEquals(true, itr.hasNext());
        int next = itr.next().intValue();
        assertTrue(next == 1 || next == 2);
        next = itr.next().intValue();
        assertTrue(next == 1 || next == 2);
        assertEquals(false, itr.hasNext());
    }
}