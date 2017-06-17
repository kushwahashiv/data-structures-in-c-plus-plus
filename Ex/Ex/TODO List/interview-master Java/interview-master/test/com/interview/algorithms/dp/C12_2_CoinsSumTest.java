package com.interview.algorithms.dp;

import com.interview.utils.ConsoleWriter;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 3/14/14
 * Time: 4:10 PM
 */
public class C12_2_CoinsSumTest {

    @Test
    public void testGetMinCoinsCount() {
        C12_2_CoinsSum test = new C12_2_CoinsSum();
        int S = 11;
        int[] values = new int[] {1, 3, 5};
        int minCount = test.getMinNumberOfCoints(S, values);
        Assert.assertEquals(minCount, 3);
    }



    @Test
    public void getMinCoinsSolution() {
        C12_2_CoinsSum test = new C12_2_CoinsSum();
        int S = 11;
        int[] values = new int[] {1, 3, 5};
        int[] sol = test.getMinCoinsSolution(S, values);
        Assert.assertEquals(1, sol[0]); // 1 coin of value 1
        Assert.assertEquals(2, sol[2]); // 2 coins of value 5
    }

    @Test
    public void testForNotFound() {
        C12_2_CoinsSum test = new C12_2_CoinsSum();
        int S = 17;
        int[] values = new int[] {3, 5, 6};
        int minCount = test.getMinNumberOfCoints(S, values);
        Assert.assertEquals(minCount, -1);
        int[] sol = test.getMinCoinsSolution(S, values);
        ConsoleWriter.printIntArray(sol);
        Assert.assertEquals(0, sol[0]); // 1 coin of value 1
        Assert.assertEquals(0, sol[1]); // 2 coins of value 5
        Assert.assertEquals(0, sol[2]); // 1 coin of value 1
    }
}
