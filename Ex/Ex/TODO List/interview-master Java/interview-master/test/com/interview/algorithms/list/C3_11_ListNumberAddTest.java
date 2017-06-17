package com.interview.algorithms.list;

import com.interview.basics.model.collection.list.LinkedList;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-10
 * Time: 下午10:31
 */
public class C3_11_ListNumberAddTest extends TestCase {
    public void testcase1(){
        LinkedList<Integer> number1 = new LinkedList<>();
        number1.add(2);
        number1.add(4);
        number1.add(4);

        LinkedList<Integer> number2 = new LinkedList<>();
        number2.add(3);
        number2.add(5);
        number2.add(7);

        LinkedList<Integer> sum = C3_11_ListNumberAdd.add(number1, number2);
        Integer[] expected = new Integer[] {5,9,1,1};
        for(int i = 0; i < sum.size(); i ++)
            assertEquals(expected[i], sum.get(i));

        sum = C3_11_ListNumberAdd.addRecursive(number1, number2);
        for(int i = 0; i < sum.size(); i ++)
            assertEquals(expected[i], sum.get(i));
    }

    public void testcase2(){
        LinkedList<Integer> number1 = new LinkedList<>();
        number1.add(2);
        number1.add(4);
        number1.add(4);

        LinkedList<Integer> number2 = new LinkedList<>();

        LinkedList<Integer> sum = C3_11_ListNumberAdd.add(number1, number2);
        Integer[] expected = new Integer[] {2,4,4};
        for(int i = 0; i < sum.size(); i ++)
            assertEquals(expected[i], sum.get(i));

        sum = C3_11_ListNumberAdd.addRecursive(number1, number2);
        for(int i = 0; i < sum.size(); i ++)
            assertEquals(expected[i], sum.get(i));
    }

    public void testcase3(){
        LinkedList<Integer> number1 = new LinkedList<>();
        number1.add(2);
        number1.add(4);
        number1.add(3);

        LinkedList<Integer> number2 = new LinkedList<>();
        number2.add(9);
        number2.add(5);
        number2.add(6);

        LinkedList<Integer> sum = C3_11_ListNumberAdd.add(number1, number2);
        Integer[] expected = new Integer[] {1,0,0,1};
        for(int i = 0; i < sum.size(); i ++)
            assertEquals(expected[i], sum.get(i));

        sum = C3_11_ListNumberAdd.addRecursive(number1, number2);
        for(int i = 0; i < sum.size(); i ++)
            assertEquals(expected[i], sum.get(i));
    }

    public void testcase4(){
        LinkedList<Integer> number1 = new LinkedList<>();
        number1.add(2);
        number1.add(4);
        number1.add(4);

        LinkedList<Integer> number2 = new LinkedList<>();
        number2.add(3);
        number2.add(5);
        number2.add(7);
        number2.add(3);

        LinkedList<Integer> sum = C3_11_ListNumberAdd.add(number1, number2);
        Integer[] expected = new Integer[] {5,9,1,4};
        for(int i = 0; i < sum.size(); i ++)
            assertEquals(expected[i], sum.get(i));

        sum = C3_11_ListNumberAdd.addRecursive(number1, number2);
        for(int i = 0; i < sum.size(); i ++)
            assertEquals(expected[i], sum.get(i));
    }

    public void testcase5(){
        LinkedList<Integer> number1 = new LinkedList<>();
        number1.add(12);
        number1.add(4);
        number1.add(4);

        LinkedList<Integer> number2 = new LinkedList<>();
        number2.add(3);
        number2.add(5);
        number2.add(17);

        LinkedList<Integer> sum = C3_11_ListNumberAdd.add(number1, number2);
        Integer[] expected = new Integer[] {5,0,2,2};
        for(int i = 0; i < sum.size(); i ++)
            assertEquals(expected[i], sum.get(i));

        sum = C3_11_ListNumberAdd.addRecursive(number1, number2);
        for(int i = 0; i < sum.size(); i ++)
            assertEquals(expected[i], sum.get(i));
    }
}
