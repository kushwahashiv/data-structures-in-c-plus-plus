package com.interview.algorithms.string;

import com.interview.util.TestUtil;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

public class C11_17_BasicStringOpTest extends TestCase {

    @Test
    public void testReverse(){
        String str = TestUtil.generateString();
        System.out.println("Source String: " + str);
        String reverse = C11_17_BasicStringOp.reverse(str);
        System.out.println("Reverse String: " + reverse);
        for(int i = 0; i < str.length(); i++){
            Assert.assertEquals(str.charAt(i), reverse.charAt(str.length() - i - 1));
        }
    }

    @Test
    public void testSuffixes(){
        String str = TestUtil.generateString();
        System.out.println("Source String: " + str);
        String[] suffiexs = C11_17_BasicStringOp.suffixes(str);
        for(String suff : suffiexs){
            System.out.println("Suffixes String: " + suff);
        }
    }

    @Test
    public void testLCP(){
        String str1 = TestUtil.generateString();
        System.out.println("Generate String Str1: " + str1);
        String str2 = TestUtil.generateString();
        System.out.println("Generate String Str2: " + str2);
        int len = C11_17_BasicStringOp.lcp(str1, str2);
        System.out.println("LCP is: " + len);
    }

}