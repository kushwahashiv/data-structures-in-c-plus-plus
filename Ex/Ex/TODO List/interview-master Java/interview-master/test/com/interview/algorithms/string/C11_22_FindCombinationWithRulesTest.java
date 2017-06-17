package com.interview.algorithms.string;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created_By: stefanie
 * Date: 14-8-26
 * Time: 下午4:00
 */
public class C11_22_FindCombinationWithRulesTest extends TestCase {
    public void testFind1() throws Exception {
        Map<Integer, Integer[]> placeMap = new HashMap<Integer, Integer[]>();
        placeMap.put(3, new Integer[]{4});
        Map<Integer, Integer[]> neighborMap = new HashMap<Integer, Integer[]>();
        neighborMap.put(3, new Integer[]{5});
        neighborMap.put(5, new Integer[]{3});
        C11_22_FindCombinationWithRules finder = new C11_22_FindCombinationWithRules(5, placeMap, neighborMap);

        List<String> combinations = finder.find();
        //System.out.println(combinations.size());
        assertEquals(56, combinations.size());
        for(String str : combinations) {
            //System.out.println(str);
            assertFalse(str.charAt(2) == '4');
            assertFalse(str.contains("35"));
            assertFalse(str.contains("53"));
        }

    }

    public void testFind2() throws Exception {
        Map<Integer, Integer[]> placeMap = new HashMap<Integer, Integer[]>();
        placeMap.put(1, new Integer[]{2});
        placeMap.put(2, new Integer[]{3,5});
        Map<Integer, Integer[]> neighborMap = new HashMap<Integer, Integer[]>();
        neighborMap.put(4, new Integer[]{2,1});
        neighborMap.put(2, new Integer[]{4});
        neighborMap.put(1, new Integer[]{4});
        C11_22_FindCombinationWithRules finder = new C11_22_FindCombinationWithRules(6, placeMap, neighborMap);

        List<String> combinations = finder.find();
        //System.out.println(combinations.size());
        assertEquals(146, combinations.size());
        //ConsoleWriter.printList(combinations);
        for(String str : combinations) {
            //System.out.println(str);
            assertFalse(str.charAt(0) == '2');
            assertFalse(str.charAt(1) == '3');
            assertFalse(str.charAt(1) == '5');
            assertFalse(str.contains("41"));
            assertFalse(str.contains("14"));
            assertFalse(str.contains("24"));
            assertFalse(str.contains("42"));
        }

    }
}
