package com.interview.algorithms.design;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.Map;

/**
 * Created_By: stefanie
 * Date: 14-8-22
 * Time: 上午9:36
 */
public class C9_3_AntGameTest extends TestCase {

    public void testFind1() throws Exception {
        int[] ants = new int[]{3,7,27};
        C9_3_AntGame game = new C9_3_AntGame(27, ants);
        Map<Integer, boolean[]> solutions = game.find();
        for(Map.Entry<Integer, boolean[]> entry : solutions.entrySet()){
            System.out.println("Found Solution Time: " + entry.getKey());
            ConsoleWriter.printBooleanArray(entry.getValue());
        }

        Result r = game.findResult();
        assertEquals(27, r.max);
        assertEquals(7, r.min);
    }

    public void testFind2() throws Exception {
        int[] ants = new int[]{3,7,11,17,23};
        C9_3_AntGame game = new C9_3_AntGame(27, ants);
        Map<Integer, boolean[]> solutions = game.find();
        for(Map.Entry<Integer, boolean[]> entry : solutions.entrySet()){
            System.out.println("Found Solution Time: " + entry.getKey());
            ConsoleWriter.printBooleanArray(entry.getValue());
        }

        Result r = game.findResult();
        assertEquals(11, r.min);
        assertEquals(24, r.max);
    }
}
