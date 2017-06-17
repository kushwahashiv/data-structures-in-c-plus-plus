package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-24
 * Time: 下午10:07
 */
public class C4_34_FindSwitchMakeSumCloseTest extends TestCase {
    public void testSwitchByBF() throws Exception {
        Integer[] a= new Integer[]{4,99,98,1,2, 3};
        Integer[] b= new Integer[]{1, 2, 3, 4,5,40};
        int gap = C4_34_FindSwitchMakeSumClose.findSwitchByBF(a, b);
        System.out.println(gap);
        ConsoleWriter.printIntArray(a);
        System.out.println(C4_34_FindSwitchMakeSumClose.sum(a));
        ConsoleWriter.printIntArray(b);
        System.out.println(C4_34_FindSwitchMakeSumClose.sum(b));

    }

    public void testSwitchOne() throws Exception {
        Integer[] a= new Integer[]{4,99,98,1,2, 3};
        Integer[] b= new Integer[]{1, 2, 3, 4,5,40};
        int gap = C4_34_FindSwitchMakeSumClose.switchOne(a, b);
        System.out.println(gap);
        ConsoleWriter.printIntArray(a);
        System.out.println(C4_34_FindSwitchMakeSumClose.sum(a));
        ConsoleWriter.printIntArray(b);
        System.out.println(C4_34_FindSwitchMakeSumClose.sum(b));
    }
}
