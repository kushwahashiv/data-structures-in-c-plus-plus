package com.interview.algorithms.string;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.Set;

/**
 * Created_By: stefanie
 * Date: 14-9-17
 * Time: 下午10:46
 */
public class C11_28_BrotherWordsTest extends TestCase {
    public void testcase(){
        testBrotherWords("hello", 1);
        testBrotherWords("mary", 4);
    }

    public void testBrotherWords(String word, int size) {
        Set<String> words = C11_28_BrotherWords.INSTANCE.brotherWords(word);
        assertEquals(size, words.size());
        ConsoleWriter.printList(words);
    }
}
