package com.interview.algorithms.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 3/25/14
 * Time: 10:16 PM
 */
public class C12_6_BadNeighborsTest {

    @Test
    public void testBadNeighbors() {
        C12_6_BadNeighbors test = new C12_6_BadNeighbors();

        int[] donations = new int[] { 10, 3, 2, 5, 7, 8 };
        Assert.assertEquals(test.maxDonationsByRecursion(donations, 0, donations.length - 1), 19);
        Assert.assertEquals(test.maxDonationsDP(donations), 19);

        donations = new int[] { 11, 15};
        Assert.assertEquals(test.maxDonationsByRecursion(donations, 0, donations.length - 1), 15);
        Assert.assertEquals(test.maxDonationsDP(donations), 15);

        donations = new int[] { 7, 7, 7, 7, 7, 7, 7 };
        Assert.assertEquals(test.maxDonationsByRecursion(donations, 0, donations.length - 1), 21);
        Assert.assertEquals(test.maxDonationsDP(donations), 21);

        donations = new int[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
        Assert.assertEquals(test.maxDonationsByRecursion(donations, 0, donations.length - 1), 16);
        Assert.assertEquals(test.maxDonationsDP(donations), 16);

        donations = new int[] { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
        Assert.assertEquals(test.maxDonationsByRecursion(donations, 0, donations.length - 1), 2926);
        Assert.assertEquals(test.maxDonationsDP(donations), 2926);
    }
}
