package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-1
 * Time: 下午10:45
 */
public class C1_43_PokerStraightTest extends TestCase {

    public void testcase1(){
        String[] card = new String[]{"1", "2", "3", "4", "5"};
        assertEquals(true, C1_43_PokerStraight.isStraight(card));
    }

    public void testcase2(){
        String[] card = new String[]{"1", "5", "King", "4", "2"};
        assertEquals(true, C1_43_PokerStraight.isStraight(card));
    }

    public void testcase3(){
        String[] card = new String[]{"7", "8", "9", "10", "J"};
        assertEquals(true, C1_43_PokerStraight.isStraight(card));
    }

    public void testcase4(){
        String[] card = new String[]{"9", "10", "J", "Q", "K"};
        assertEquals(true, C1_43_PokerStraight.isStraight(card));
    }

    public void testcase5(){
        String[] card = new String[]{"1", "9", "3", "King", "5"};
        assertEquals(false, C1_43_PokerStraight.isStraight(card));
    }

    public void testcase6(){
        String[] card = new String[]{"7", "88", "9", "10", "J"};
        assertEquals(false, C1_43_PokerStraight.isStraight(card));
    }
}
