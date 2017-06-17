package com.interview.basics.model.collection;

import com.interview.basics.model.collection.list.ArrayList;
import com.interview.basics.model.collection.list.LinkedList;
import com.interview.basics.model.collection.list.List;
import junit.framework.TestCase;

import java.util.Iterator;

/**
 * Created_By: stefanie
 * Date: 14-7-1
 * Time: 下午10:16
 */
public class ListTest extends TestCase {
    List<String> list;

    @Override
    public void setUp() throws Exception {
        list = new ArrayList<>();
        //list = new LinkedList<>();
    }

    private void prepareData(){
        list.add("a");
        list.add("b");
        list.add("a");
    }

    public void testAdd() throws Exception {
        assertEquals(0, list.size());
        list.add("a");
        assertEquals(1, list.size());
        list.add("b");
        assertEquals(2, list.size());
        list.add("a");
        assertEquals(3, list.size());
    }

    public void testGet() throws Exception {
        prepareData();
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("a", list.get(2));
    }

    public void testSet(){
        prepareData();
        assertEquals("b", list.get(1));
        list.set(1, "f");
        assertEquals("f", list.get(1));
    }

    public void testIndexOf() throws Exception {
        prepareData();
        assertEquals(0, list.indexOf("a"));
        assertEquals(1, list.indexOf("b"));
        assertEquals(-1, list.indexOf("f"));
    }

    public void testAddByIndex() throws Exception {
        prepareData();
        assertEquals("b", list.get(1));
        list.add(1, "e");
        assertEquals("e", list.get(1));
    }

    public void testContains() throws Exception {
        prepareData();
        assertEquals(true, list.contains("b"));
        assertEquals(false, list.contains("f"));
    }

    public void testIsEmpty() throws Exception {
        assertEquals(true, list.isEmpty());
        list.add("a");
        assertEquals(false, list.isEmpty());
    }

    public void testRemove() throws Exception{
        prepareData();
        assertEquals(3, list.size());
        assertEquals("b", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("a", list.get(1));
        list.remove(0);
        list.remove(0);
        assertEquals(true, list.isEmpty());
    }

    public void testRemoveByElement() throws Exception{
        prepareData();
        assertEquals(3, list.size());
        assertEquals("b", list.remove("b"));
        assertEquals(2, list.size());
        assertEquals("a", list.get(1));
        list.remove(0);
        list.remove(0);
        assertEquals(true, list.isEmpty());
    }

    public void testIterator() throws Exception {
        prepareData();
        Iterator<String> itr = list.iterator();
        assertEquals(true, itr.hasNext());
        assertEquals("a", itr.next());
        assertEquals("b", itr.next());
        assertEquals("a", itr.next());
        assertEquals(false, itr.hasNext());
    }
}
