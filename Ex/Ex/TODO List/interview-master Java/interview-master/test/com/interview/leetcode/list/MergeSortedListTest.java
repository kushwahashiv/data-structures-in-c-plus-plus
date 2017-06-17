package com.interview.leetcode.list;

import com.interview.leetcode.utils.ListNode;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-13
 * Time: 下午2:28
 */
public class MergeSortedListTest extends TestCase {
    public void testMerge2() throws Exception {
        ListNode a = ListNode.createList(new int[]{2,3,7,9});
        ListNode b = ListNode.createList(new int[]{4,5,7,8});
        ListNode merged = MergeSortedList.merge2(a, b);
        int[] expected = new int[]{2,3,4,5,7,7,8,9};
        for(int i = 0; i < expected.length && merged != null; i++){
            assertEquals(expected[i], merged.val);
            merged = merged.next;
        }
    }

    public void testMergek() throws Exception {
        List<ListNode> lists = new ArrayList<>();
        lists.add(ListNode.createList(new int[]{2,3,7,9}));
        lists.add(ListNode.createList(new int[]{4,5,7,8}));
        lists.add(ListNode.createList(new int[]{0,2,9,10,20}));

        ListNode merged = MergeSortedList.mergek(lists);
        int[] expected = new int[]{0,2,2,3,4,5,7,7,8,9,9,10,20};
        for(int i = 0; i < expected.length && merged != null; i++){
            assertEquals(expected[i], merged.val);
            merged = merged.next;
        }
    }
}
