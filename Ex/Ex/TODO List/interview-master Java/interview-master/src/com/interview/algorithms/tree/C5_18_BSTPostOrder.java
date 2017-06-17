package com.interview.algorithms.tree;

import com.interview.basics.model.collection.list.List;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/22/14
 * Time: 1:34 PM
 *
 * Given a sequence of int, write code to check if this the post-order traverse of a binary search tree.
 *
 * post order: the last number is the root of the tree, and it should split the sequence into two set:
 *  smaller than it and larger then it as the two sub-tree.
 *  recursive the check if the seq follow the above rule.
 */
public class C5_18_BSTPostOrder {

    public static boolean check(Integer[] array){
        return check(array, 0, array.length - 1);
    }

    public static boolean check(Integer[] a, int s, int e){
        if (e <= s) return true;
        int i = e-1;
        while (i >= s && a[e] <= a[i]) i--;
        if (!check(a, i+1, e-1))
            return false;
        int k = i;
        while (i >= s && a[e] >= a[i]) i--;
        if(s == i+1) return check(a, s, k);
        else return false;
    }
}
