package com.interview.algorithms.string;

import com.interview.util.TestUtil;
import junit.framework.TestCase;
import org.junit.Test;

public class C11_16_StringSorterTest extends TestCase {

    @Test
    public void testKeyIndexedSorter(){
        char[] charlist = TestUtil.generateCharArray(30, 26);
        System.out.println("Generate Charlist: " + new String(charlist));

        C11_16_KeyIndexedSorter sorter = new C11_16_KeyIndexedSorter(C11_16_KeyIndexedSorter.CHARSET);
        sorter.sort(charlist);
        System.out.println("Key Indexed Sort Result Charlist: " + new String(charlist));
    }

    @Test
    public void testLSDSorter(){
        String[] strlist = TestUtil.generateSameLengthString(10, 50);
        System.out.println("Generate String List: ");
        for(int i = 0; i < 50; i ++){
            System.out.println(strlist[i]);
        }

        C11_16_LSDSorter.sort(strlist);

        System.out.println("Sorted String List: ");
        for(int i = 0; i < 50; i ++){
            System.out.println(strlist[i]);
        }
    }

    @Test
    public void testMSDSorter(){
        String[] strlist = TestUtil.generateSameLengthString(10, 50);
        System.out.println("Generate String List: ");
        for(int i = 0; i < 50; i ++){
            System.out.println(strlist[i]);
        }

        C11_16_MSDSorter.sort(strlist);

        System.out.println("Sorted String List: ");
        for(int i = 0; i < 50; i ++){
            System.out.println(strlist[i]);
        }
    }

}