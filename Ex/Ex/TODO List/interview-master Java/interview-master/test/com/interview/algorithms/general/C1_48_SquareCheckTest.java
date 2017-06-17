package com.interview.algorithms.general;

import com.interview.util.TestUtil;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-21
 * Time: 下午5:12
 */
public class C1_48_SquareCheckTest extends TestCase {

    public void testcase1() throws Exception {
        assertEquals(0, C1_48_SquareCheck.check(0));
    }

    public void testcase2() throws Exception {
        assertEquals(1, C1_48_SquareCheck.check(1));
    }

    public void testcase3() throws Exception {
        assertEquals(2, C1_48_SquareCheck.check(4));
    }

    public void testcase4() throws Exception {
        assertEquals(7, C1_48_SquareCheck.check(49));
    }

    public void testcase5() throws Exception {
        assertEquals(0, C1_48_SquareCheck.check(675));
    }

    public void testcase6() throws Exception {
        assertEquals(64, C1_48_SquareCheck.check(4096));
    }

    public void testcase7() throws Exception {
        assertEquals(15, C1_48_SquareCheck.check(225));
    }

    public void testcase() throws Exception {
        for(int i = 0; i < 10; i++){
            int random = TestUtil.generateInt(1000);
            System.out.println("Check " + random);
            double sqrt = Math.sqrt(random);
            if(sqrt - (int)sqrt == 0){
                assertEquals(sqrt, C1_48_SquareCheck.check(random));
            } else {
                assertEquals(0, C1_48_SquareCheck.check(random));
            }
        }
    }


}
