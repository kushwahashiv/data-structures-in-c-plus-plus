package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-10
 * Time: 下午9:54
 */
public class C3_10_ListPartitionTest extends TestCase {

    public void testPartition(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] nodes = new int[] {5,6,23,56,2,96,1,57,102,4,5};
        for(int str : nodes) list.add(str);

        C3_10_ListPartition.partition(list, 10);

        boolean small = list.get(0) < 10;
        for(int i = 0; i < list.size(); i ++) {
            if (small && list.get(i) >= 10) small = false;
            if(!small)  assertTrue(list.get(i) >= 10);
        }
    }

    public void testPartitionRecursive(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] nodes = new int[] {5,6,23,56,2,96,1,57,102,4,5};
        for(int str : nodes) list.add(str);

        C3_10_ListPartition.partitionRecursive(list, 10);

        boolean small = list.get(0) < 10;
        for(int i = 0; i < list.size(); i ++) {
            System.out.println(list.get(i));
            if (small && list.get(i) >= 10) small = false;
            if(!small)  assertTrue(list.get(i) >= 10);
        }
    }
}
