package com.interview.algorithms.general;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-6
 * Time: 上午8:40
 */
public class C1_73D_UniquePermutationTest extends TestCase {
    public void testPermuteUnique() throws Exception {
        C1_73D_UniquePermutation generator = new C1_73D_UniquePermutation();
        int[] num = new int[]{1,1,2};
        List<List<Integer>> permutations = generator.permuteUnique(num);
        assertEquals(3, permutations.size());
//        for(List<Integer> permutation : permutations){
//            for(Integer number :g permutation){
//                System.out.print(number + " ");
//            }
//            System.out.println();
//        }
    }
}
