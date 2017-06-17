package com.interview.algorithms.dp;

import com.interview.algorithms.dp.C12_21_PickFactory;
import junit.framework.TestCase;

/**
 * 工厂：{0,4,5,10}，选取1个原材料供应厂： {11,4}，最短距离为11，选取4做原材料供应厂

 工厂：{0,4,5,10}，选取2个原材料供应厂： {5,4,10}，最短距离为5，选取4,10做原材料供应厂
 工厂：{0,4,5,10,12}，选取2个原材料供应厂： {7,4,10}，最短距离为7，选取4,10做原材料供应厂

 工厂：{0,4,5,10,12}，选取3个原材料供应厂： {3,0,4,10}，最短距离为3，选取0,4,10做原材料供应厂

 工厂：{0,4,5,10,12,18,27,30,31,38,39,47}，选取3个原材料供应厂： {43,5,27,39}，最短距离为43，选取5,27,39做原材料供应厂
 */
public class C12_21_PickFactoryTest extends TestCase {
    public void testcase1(){
        int[] dist = new int[]{0,4,5,10};
        int[] factory = C12_21_PickFactory.pick(dist, 1);
        assertEquals(11, factory[0]);
        assertEquals(4, factory[1]);
    }

    public void testcase2(){
        int[] dist = new int[]{0,4,5,10};
        int[] factory = C12_21_PickFactory.pick(dist, 2);
        assertEquals(5, factory[0]);
        assertEquals(4, factory[1]);
        assertEquals(10, factory[2]);
    }

    public void testcase3(){
        int[] dist = new int[]{0,4,5,10, 12};
        int[] factory = C12_21_PickFactory.pick(dist, 2);
        assertEquals(7, factory[0]);
        assertEquals(4, factory[1]);
        assertEquals(10, factory[2]);
    }

    public void testcase4(){
        int[] dist = new int[]{0,4,5,10,12};
        int[] factory = C12_21_PickFactory.pick(dist, 3);
        assertEquals(3, factory[0]);
        assertEquals(0, factory[1]);
        assertEquals(4, factory[2]);
        assertEquals(10, factory[3]);
    }
    public void testPick() throws Exception {
        int[] dist = new int[] {0,4,5,10,12,18,27,30,31,38,39,47};
        int[] factory = C12_21_PickFactory.pick(dist, 3);
        assertEquals(43, factory[0]);
        assertEquals(5, factory[1]);
        assertEquals(27, factory[2]);
        assertEquals(39, factory[3]);

    }
}