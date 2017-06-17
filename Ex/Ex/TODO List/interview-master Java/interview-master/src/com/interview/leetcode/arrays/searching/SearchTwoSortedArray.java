package com.interview.leetcode.arrays.searching;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午9:23
 *
 *  Solution: like "find k-th element in sorted array".
 *
 *  1. have lowA and lowB pointing to the begin of searching area.
 *  2. if k == 1 return the min of A[lowA] and B[lowB]
 *  3. when k > 1, find the element offset is the k / 2 - 1 in A and B.
 *       int keyA = lowA + half - 1 < A.length? A[lowA + half - 1] : Integer.MAX_VALUE;
 *       int keyB = lowB + half - 1 < B.length? B[lowB + half - 1] : Integer.MAX_VALUE;
 *  4. if keyA > keyB, element smaller than k / 2 - 1 in A should smaller than the k-th element, should count in
 *       so search (k - k / 2)th element start from lowA + k / 2
 *     otherwise sink B from lowB + k / 2;
 *  5. checking up bound (array.length) to avoid overstep the boundary
 *
 *  Time: O(log(M + N))
 *
 */
public class SearchTwoSortedArray {
    public static int topK(int[] a, int[] b, int k){
        if(k > a.length + b.length - 1) return Integer.MAX_VALUE;
        return findKth(a, 0, b, 0, k);
    }

    public static int findKth(int[] a, int lowA, int[] b, int lowB, int k){
        if(lowA >= a.length) return b[lowB + k - 1];
        if(lowB >= b.length) return a[lowA + k - 1];
        if(k == 1) return Math.min(a[lowA], b[lowB]);
        int half = k / 2;
        int keyA = lowA + half - 1 < a.length? a[lowA + half - 1] : Integer.MAX_VALUE;
        int keyB = lowB + half - 1 < b.length? b[lowB + half - 1] : Integer.MAX_VALUE;
        if(keyA < keyB) return findKth(a, lowA + half, b, lowB, k - half);
        else return findKth(a, lowA, b, lowB + half, k - half);
    }
}
