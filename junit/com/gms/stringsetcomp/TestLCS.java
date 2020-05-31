package com.gms.stringsetcomp;

import org.junit.Assert;
import org.junit.Test;

public class TestLCS
{
    private static final String STRINGLEFT = "SUMMER SALE! Reduced $100!! Premium Grade A++ Matching Serial Numbers Russian 1891/30 7.62x54R Mosin Nagant Rifle"
        .toLowerCase();
    private static final String STRINGRIGHT = "SUMMER SALE! Reduced $175!! Presentation Grade A++ Matching Serial Numbers FREE Military Acc. Pack Value $75 WORLD WAR II ISSUE Russian 1891/30 7.62x54R Mosin Nagant Rifle"
        .toLowerCase();

    @Test
    public void test()
    {
        final LCS lcs = new LCS();

        Assert.assertEquals("Expected 1.0", 1.0, lcs.compare(null, null), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, lcs.compare(STRINGLEFT.split("\\s+"), null), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, lcs.compare(null, STRINGRIGHT.split("\\s+")), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, lcs.compare(new String[0], new String[0]), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, lcs.compare("foo".split("\\s+"), null), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, lcs.compare("foo".split("\\s+"), new String[0]), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, lcs.compare(new String[0], "foo".split("\\s+")), 0.0);
        Assert.assertEquals("Expected 0.33333333333333337", 0.3333,
            lcs.compare(STRINGLEFT.split("\\s+"), STRINGRIGHT.split("\\s+")), 0.0001);
    }
}
