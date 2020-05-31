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

public class TestDice
{
    @Test
    public void testDice()
    {
        Dice dice = new Dice();
        final String str1 = "George";
        Assert.assertEquals("Wrong1", 1.0, dice.compare(str1, str1), 0.0);
        final String str2 = "Geordie";
        final double result= dice.compare(str1, str2);
        Assert.assertTrue(0.546 > result);
        Assert.assertTrue(0.544 < result);
        Assert.assertEquals("Wrong2", 0.0, dice.compare(str1, ""), 0.0);
        Assert.assertEquals("Wrong3", 0.0, dice.compare("", str1), 0.0);
        Assert.assertEquals("Wrong4", 1 / 2.0 , dice.compare("cat", "bat"), 0.0);
        Assert.assertEquals("Wrong5", 1 / 3.0, dice.compare("abcd","dbca"), 0.0);
    }
}
