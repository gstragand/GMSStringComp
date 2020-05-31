/*
 * TestLevenshtein.java
 * 
 * Copyright 2012 George M. Stragand III.  All Rights Reserved.
 *
 * This software is the proprietary information of George M. Stragand III.
 * Use is subject to license terms.
 */
package com.gms.strcomp;

import org.junit.Assert;
import org.junit.Test;

public class TestLevenshtein
{
    @Test
    public void testCompare()
    {
        final Levenshtein levenshtein = new Levenshtein();
        final String str1 = "George";
        Assert.assertEquals("Wrong", 1.0, levenshtein.compare(str1, str1), 0.0);
        final String str2 = "Geordie";
        final double result = levenshtein.compare(str1, str2);
        Assert.assertTrue(0.72 > result);
        Assert.assertTrue(0.71 < result);
        Assert.assertEquals("Wrong", 6.0, levenshtein.compare(str1, ""), 0.0);
        Assert.assertEquals("Wrong", 6.0, levenshtein.compare("", str1), 0.0);
    }

    @Test
    public void testNameCompare()
    {
        final NameLevenshtein nameLevenshtein = new NameLevenshtein();
        Assert.assertTrue(0.77 < nameLevenshtein.compare("George M. Stragand", "Stragand, George"));
        Assert.assertTrue(0.76 > nameLevenshtein.compare("George M. Stragand", "King Leonidas"));
        Assert.assertTrue(0.87 < nameLevenshtein.compare("Geordie Stragand", "George Stragand"));
    }
}
