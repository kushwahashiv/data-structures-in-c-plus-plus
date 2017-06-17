package com.interview.algorithms.general;

import com.interview.util.TestUtil;
import junit.framework.TestCase;

import java.io.FileWriter;

/**
 * Created_By: stefanie
 * Date: 14-7-8
 * Time: 下午10:29
 */
public class C1_29_FindUnduplicateIntegerTest extends TestCase {

//    public void testCode() throws Exception{
//        FileWriter writer = new FileWriter("documents/C1_29_FindUnduplicateIntegerText1.txt");
//        for(long i = 0; i < 50000L; i++){
//            int number = TestUtil.generateInt(10000);
//            if(TestUtil.generateInt(1) > 0) number = 0-number;
//            writer.write(number + "\n");
//            if(i % 1000 == 0) writer.flush();
//        }
//        writer.flush();
//    }

    public void testcase1(){
        int number = C1_29_FindUnduplicateInteger.unduplicateNumber("test_documents/C1_29_FindUnduplicateIntegerText2.txt", 10000);
        assertEquals(3, number);
    }

    public void testcase2(){
        int number = C1_29_FindUnduplicateInteger.unduplicateNumber("test_documents/C1_29_FindUnduplicateIntegerText1.txt", 10000);
        assertEquals(4052, number);
    }
}
