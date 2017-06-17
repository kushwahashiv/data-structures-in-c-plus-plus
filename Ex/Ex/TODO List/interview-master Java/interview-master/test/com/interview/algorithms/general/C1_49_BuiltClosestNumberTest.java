package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-21
 * Time: 下午9:56
 */
public class C1_49_BuiltClosestNumberTest extends TestCase {
    int[] a = new int[]{0,1};
    int[] b = new int[]{0,1,3,8};

    public void testcase1(){
        int num = C1_49_BuiltClosestNumber.build(a, 9);
        assertEquals(10, num);
    }
    public void testcase2(){
        int num = C1_49_BuiltClosestNumber.build(a, 21);
        assertEquals(100, num);
    }
    public void testcase3(){
        int num = C1_49_BuiltClosestNumber.build(a, 11);
        assertEquals(100, num);
    }
    public void testcase4(){
        int num = C1_49_BuiltClosestNumber.build(a, 10);
        assertEquals(11, num);
    }
    public void testcase5(){
        int num = C1_49_BuiltClosestNumber.build(b, 9);
        assertEquals(10, num);
    }

    public void testcase6(){
        int num = C1_49_BuiltClosestNumber.build(b, 13);
        assertEquals(18, num);
    }

    public void testcase7(){
        int num = C1_49_BuiltClosestNumber.build(b, 218);
        assertEquals(300, num);
    }

    public void testcase8(){
        int num = C1_49_BuiltClosestNumber.build(b, 108);
        assertEquals(110, num);
    }

    public void testcase9(){
        int num = C1_49_BuiltClosestNumber.build(b, 109);
        assertEquals(110, num);
    }
}
