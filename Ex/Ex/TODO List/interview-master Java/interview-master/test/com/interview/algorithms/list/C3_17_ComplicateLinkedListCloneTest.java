package com.interview.algorithms.list;

import junit.framework.TestCase;

import java.util.Random;

/**
 * Created_By: stefanie
 * Date: 14-8-5
 * Time: 下午11:05
 */
public class C3_17_ComplicateLinkedListCloneTest extends TestCase {
    public ComplicateNode<String> generateComplicateList(){
        ComplicateNode<String> list = new ComplicateNode<>("0");
        ComplicateNode<String> p = list;
        for(int i = 1; i < 10; i++){
            p.next = new ComplicateNode<String>(String.valueOf(i));
            p = p.next;
        }

        p = list;
        while(p != null){
            int i = new Random().nextInt(11);
            if(i >= 10) p.sibling = null;
            else {
                ComplicateNode<String> q = list;
                while(i-- > 0) q = q.next;
                p.sibling = q;
            }
            p = p.next;
        }
        return list;
    }

    public void testClone() throws Exception {

        ComplicateNode<String> list = generateComplicateList();
        ComplicateNode<String> copy = C3_17_ComplicateLinkedListClone.clone(list);
        while(list != null){
            assertFalse(list == copy);
            assertEquals(list.item, copy.item);
            if(list.sibling == null)
                assertNull(copy.sibling);
            else{
                assertFalse(list.sibling == copy.sibling);
                assertEquals(list.sibling.item, copy.sibling.item);
            }
            list = list.next;
            copy = copy.next;
        }

    }
}
