package com.interview.algorithms.string;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C11_25_StringSetCombineTest extends TestCase {

    //Such as {aa,bb,cc},{bb,dd},{hh},{uu,jj},{dd,kk}, the result should be {aa,bb,cc,dd,kk},{hh},{uu,jj}
    public void testCombine() throws Exception {
        List<Set<String>> input = new ArrayList<Set<String>>();
        Set<String> set = new HashSet<String>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        input.add(set);

        set = new HashSet<String>();
        set.add("dd");
        set.add("bb");
        input.add(set);

        set = new HashSet<String>();
        set.add("hh");
        input.add(set);

        set = new HashSet<String>();
        set.add("uu");
        set.add("jj");
        input.add(set);

        set = new HashSet<String>();
        set.add("dd");
        set.add("kk");
        input.add(set);

        List<Set<String>> result = C11_25_StringSetCombine.combine(input);
        for(Set<String> item : result){
            System.out.println(item);
            boolean flag = false;
            if(item.size() == 1 && item.contains("hh")) flag = true;
            else if(item.size() == 2 && item.contains("uu") && item.contains("jj")) flag = true;
            else if(item.size() == 5 && item.contains("aa") && item.contains("bb")
                    && item.contains("cc") && item.contains("dd") && item.contains("kk")) flag = true;
            //assertTrue(flag);
        }
    }
}