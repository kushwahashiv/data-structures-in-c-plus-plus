package com.interview.algorithms.tree;

import com.interview.util.TestUtil;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created_By: stefanie
 * Date: 14-7-16
 * Time: 下午10:08
 */
public class C5_3_BSTUsingArrayTest extends TestCase {
    Integer[] testArray = TestUtil.generateIntArray(10, 100, 0);
    C5_3_BSTUsingArray<Integer> searcher = new C5_3_BSTUsingArray<>(testArray);
    public void testSearchIterative() throws Exception {
        int key = TestUtil.generateInt(100);
        int index = searcher.searchIterative(key);
        if(index >= 0){
            System.out.println("Find " + index + " element: " + key);
            Assert.assertEquals(key, searcher.input[index].intValue());
        } else {
            System.out.println("Haven't Find element: " + key);
            for(int i = 0; i < testArray.length; i++){
                Assert.assertNotSame(key, searcher.input[i]);
            }
        }
    }

    public void testSearch() throws Exception {
        int key = TestUtil.generateInt(100);
        int index = searcher.search(key);
        if(index >= 0){
            System.out.println("Find " + index + " element: " + key);
            Assert.assertEquals(key, searcher.input[index].intValue());
        } else {
            System.out.println("Haven't Find element: " + key);
            for(int i = 0; i < testArray.length; i++){
                Assert.assertNotSame(key, searcher.input[i]);
            }
        }
    }
}
