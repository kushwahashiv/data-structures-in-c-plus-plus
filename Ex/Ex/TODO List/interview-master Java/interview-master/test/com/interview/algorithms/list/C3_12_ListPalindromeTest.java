package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import junit.framework.TestCase;

public class C3_12_ListPalindromeTest extends TestCase {

    public void testcase1(){
        LinkedList<String> list = new LinkedList<>();
        String[] nodes = new String[] {"a","b", "c", "b", "a"};
        for(String str : nodes) list.add(str);

        assertEquals(true, C3_12_ListPalindrome.isParlindromeByStack(list));
        assertEquals(true, C3_12_ListPalindrome.isParlindromeByRecursive(list));
    }

    public void testcase2(){
        LinkedList<String> list = new LinkedList<>();
        String[] nodes = new String[] {"a","b", "c", "c", "b", "a"};
        for(String str : nodes) list.add(str);

        assertEquals(true, C3_12_ListPalindrome.isParlindromeByStack(list));
        assertEquals(true, C3_12_ListPalindrome.isParlindromeByRecursive(list));
    }

    public void testcase3(){
        LinkedList<String> list = new LinkedList<>();
        String[] nodes = new String[] {"a","b", "c", "b", "a", "e"};
        for(String str : nodes) list.add(str);

        assertEquals(false, C3_12_ListPalindrome.isParlindromeByStack(list));
        assertEquals(false, C3_12_ListPalindrome.isParlindromeByRecursive(list));
    }

    public void testcase4(){
        LinkedList<String> list = new LinkedList<>();
        String[] nodes = new String[] {"a"};
        for(String str : nodes) list.add(str);

        assertEquals(true, C3_12_ListPalindrome.isParlindromeByStack(list));
        assertEquals(true, C3_12_ListPalindrome.isParlindromeByRecursive(list));
    }

}