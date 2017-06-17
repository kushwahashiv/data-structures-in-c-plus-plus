package com.interview.algorithms.string;

import junit.framework.TestCase;

import java.util.Iterator;


/**
 * Created_By: stefanie
 * Date: 14-10-9
 * Time: 下午3:10
 */
public class C11_30_WordTranslationTest extends TestCase {
    public void testcase1(){
        C11_30_WordTranslation translation = new C11_30_WordTranslation("");
        Iterator<String> path = translation.solve("damp", "like").iterator();
        while(path.hasNext()){
            System.out.println(path.next());
        }
        System.out.println("damp");
    }

    public void testcase2(){
        C11_30_WordTranslation translation = new C11_30_WordTranslation("");
        Iterator<String> path = translation.solve("dog", "cat").iterator();
        while(path.hasNext()){
            System.out.println(path.next());
        }
        System.out.println("dog");
    }

    public void testcase3(){
        C11_30_WordTranslation translation = new C11_30_WordTranslation("");
        Iterator<String> path = translation.solve("avoid", "wrong").iterator();
        while(path.hasNext()){
            System.out.println(path.next());
        }
        System.out.println("avoid");
    }
}
