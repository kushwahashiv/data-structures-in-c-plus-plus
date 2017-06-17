package com.interview.algorithms.general;

import com.interview.util.TestUtil;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-23
 * Time: 下午10:08
 */
public class C1_37_NContainsOneNumberTest extends TestCase {
    public void testcase1(){
//        System.out.println(C1_37_NContainsOneNumber.correctAnswer(9));
//        System.out.println(C1_37_NContainsOneNumber.correctAnswer(99));
//        System.out.println(C1_37_NContainsOneNumber.correctAnswer(999));
//        System.out.println(C1_37_NContainsOneNumber.correctAnswer(12));

        assertEquals(5, C1_37_NContainsOneNumber.number(12));
        assertEquals(5, C1_37_NContainsOneNumber.numberRecursive(12));
        assertEquals(5, C1_37_NContainsOneNumber.numberLoop(12));
    }

    public void testcase2(){
        //System.out.println(C1_37_NContainsOneNumber.correctAnswer(10));
        assertEquals(2, C1_37_NContainsOneNumber.number(10));
        assertEquals(2, C1_37_NContainsOneNumber.numberRecursive(10));
        assertEquals(2, C1_37_NContainsOneNumber.numberLoop(10));
    }

    public void testcase3(){
        //System.out.println(C1_37_NContainsOneNumber.correctAnswer(11));
        assertEquals(4, C1_37_NContainsOneNumber.number(11));
        assertEquals(4, C1_37_NContainsOneNumber.numberRecursive(11));
        assertEquals(4, C1_37_NContainsOneNumber.numberLoop(11));
    }

    public void testcase4(){
        //System.out.println(C1_37_NContainsOneNumber.correctAnswer(111));
        assertEquals(36, C1_37_NContainsOneNumber.number(111));
        assertEquals(36, C1_37_NContainsOneNumber.numberRecursive(111));
        assertEquals(36, C1_37_NContainsOneNumber.numberLoop(111));
    }

    public void testcase5(){
        System.out.println(C1_37_NContainsOneNumber.correctAnswer(101));
        assertEquals(23, C1_37_NContainsOneNumber.number(101));
        assertEquals(23, C1_37_NContainsOneNumber.numberRecursive(101));
        assertEquals(23, C1_37_NContainsOneNumber.numberLoop(101));
    }

    public void testRandom(){
        for(int i = 0; i < 10; i++){
            int number = TestUtil.generateInt(10000);
            int ca = C1_37_NContainsOneNumber.correctAnswer(number);

            assertEquals(ca, C1_37_NContainsOneNumber.number(number));
            assertEquals(ca, C1_37_NContainsOneNumber.numberRecursive(number));
            assertEquals(ca, C1_37_NContainsOneNumber.numberLoop(number));
        }
    }
}
