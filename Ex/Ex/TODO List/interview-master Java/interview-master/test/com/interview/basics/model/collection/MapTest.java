package com.interview.basics.model.collection;

import com.interview.basics.model.collection.hash.HashMap;
import com.interview.basics.model.collection.hash.Map;
import junit.framework.TestCase;

import java.util.Iterator;

public class MapTest extends TestCase {
    Map<String, Integer> map;

    @Override
    public void setUp() throws Exception {
        map = new HashMap<String, Integer>();
    }

    public void testPut() throws Exception {
        map.put("a", 0);
        assertEquals(1, map.size());
        map.put("a", 1);
        assertEquals(1, map.size());
        map.put("b", 2);
        assertEquals(2, map.size());
    }

    public void testGet() throws Exception {
        map.put("a", 1);
        map.put("b", 2);
        assertEquals(1, map.get("a").intValue());
        assertEquals(2, map.get("b").intValue());
        map.put("b", 3);
        assertEquals(3, map.get("b").intValue());
        assertEquals(null, map.get("c"));
    }

    public void testIsEmpty() throws Exception {
        assertEquals(true, map.isEmpty());
        map.put("a", 1);
        assertEquals(false, map.isEmpty());
    }

    public void testSize() throws Exception {
        assertEquals(0, map.size());
        map.put("a", 1);
        assertEquals(1, map.size());
    }

    public void testKeySet() throws Exception {
        map.put("a", 1);
        map.put("b", 2);
        assertTrue(map.keySet().contains("a"));
        assertTrue(map.keySet().contains("b"));
        assertFalse(map.keySet().contains("c"));
    }

    public void testRemove(){
        map.put("a", 1);
        map.put("b", 2);
        assertEquals(1, map.get("a").intValue());
        map.remove("a");
        assertEquals(null, map.get("a"));
    }
}