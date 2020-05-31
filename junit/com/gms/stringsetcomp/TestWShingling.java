package com.gms.stringsetcomp;

import org.junit.Assert;
import org.junit.Test;

public class TestWShingling
{
    private static final String STRINGLEFT = "SUMMER SALE! Reduced $100!! Premium Grade A++ Matching Serial Numbers Russian 1891/30 7.62x54R Mosin Nagant Rifle"
        .toLowerCase();
    private static final String STRINGRIGHT = "SUMMER SALE! Reduced $175!! Presentation Grade A++ Matching Serial Numbers FREE Military Acc. Pack Value $75 WORLD WAR II ISSUE Russian 1891/30 7.62x54R Mosin Nagant Rifle"
        .toLowerCase();
    private static final String STRINGRIGHTCLOSE = "SUMMER SALE! Reduced $175!! Presentation Grade A++ Matching Serial Numbers FREE Military Acc. Pack Value $75 Russian 1891/30 7.62x54R Mosin Nagant Rifle"
        .toLowerCase();
    private static final String QUICKBROWNFOX = "Quick Brown Fox";

    @Test
    public void testWShingling()
    {
        final WShingling wShingling = new WShingling(3);

        Assert.assertEquals("Expected 1.0", 1.0, wShingling.compare(null, null), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, wShingling.compare(STRINGLEFT.split("\\s+"), null), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, wShingling.compare(null, STRINGRIGHT.split("\\s+")), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, wShingling.compare(new String[0], new String[0]), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, wShingling.compare("foo".split("\\s+"), null), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, wShingling.compare("foo".split("\\s+"), new String[0]), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, wShingling.compare(new String[0], "foo".split("\\s+")), 0.0);
        Assert.assertEquals("Expected 0.0", 0.0,
            wShingling.compare(QUICKBROWNFOX.split("\\s+"), QUICKBROWNFOX.split("\\s+")), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, wShingling.compare(QUICKBROWNFOX.split("\\s+"), null), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, wShingling.compare(null, QUICKBROWNFOX.split("\\s+")), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, wShingling.compare(QUICKBROWNFOX.split("\\s+"), new String[0]), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, wShingling.compare(new String[0], QUICKBROWNFOX.split("\\s+")), 0.0);
        Assert.assertEquals("Expected 0.0", 0.0,
            wShingling.compare(STRINGLEFT.split("\\s+"), STRINGLEFT.split("\\s+")), 0.0);
        Assert.assertEquals("Expected 0.7333333333333334", 0.7333,
            wShingling.compare(STRINGLEFT.split("\\s+"), STRINGRIGHT.split("\\s+")), 0.0001);
        Assert.assertEquals("Expected 0.3076923076923077", 0.3076,
            wShingling.compare(STRINGRIGHT.split("\\s+"), STRINGRIGHTCLOSE.split("\\s+")), 0.0001);
    }
}
