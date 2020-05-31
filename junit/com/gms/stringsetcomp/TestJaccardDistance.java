package com.gms.stringsetcomp;

import org.junit.Assert;
import org.junit.Test;

public class TestJaccardDistance
{
    private final static String StringInput = "the quick brown fox";

    private final static String DescriptionLeft = "Here is a nice little Italian Carcano Cavalry Carbine. In o/a G-VG condition. Everything works as it should. Retaining about 20% original finish it has no rust or pitting. The bore has strong rifling but is dark in the grooves. Used by both the Italian and German Forces during WW2. Three day NON-firing inspection period. Full refund if not as described. My FFL Dealer to either your FFL Dealer or your C&R License address if in your name. It does have light import marks just to the rear of the bayonet. Please see my other auction items."
        .toLowerCase();
    private final static String DescriptionRight = "Model 91 Carcano WWI combat rifle with bayonet. One of the best examples of this Italian service rifle. Stock is great with no issues; dark and smooth. Metal is in the all around 88 to 90% range with no issues. The bayonet is solid, sharp, and clean. The only thing missing is a cleaning rod. Only negatives are 2 spots on receiver where it appears proofs or crests were marked out, see photos. Rifle is dated 1918. Bore is in the 85% range or better. This rifle is a good shooter; as well as, an original vintage piece. Rifle comes with free Mosin Nagant sling attached that works great. I am an individual so, please, be sure your FFL will accept a shipment from an individual. If you pay by check I will hold till clear. Thanks for looking."
        .toLowerCase();
    private final static String DescriptionDifferent = "THESE ARE REAL WII 1939 BLUED CLIPS (NOT REPLACEMENT COPYS) I HAVE NEW PERFECT CLIPS FROM 1939 JUST LIKE THEY WERE MADE YESTERDAY READ MY FEEDBACK AND BID WITH CONFIDENCE 6 round stripper clips(2)for use with 6.5 and 7.35 Carcano ammunition.if you have a carcano rifle you know that you need these to use the gun. never can have enough!!! Fits the following models: Model: CARCANO 1891, 38, 91/38, 1941. THIS IS A FILE PHOTO. CLIPS ARE NEW OLD STOCK FROM WWII BOXED AMMO JUST OPENED A NEW CRATE VERY NICE."
        .toLowerCase();
    private final static String CloserLeft = "Swiss Schmidt Rubin K-31, 7.5x55 Rifle".toLowerCase();
    private final static String CloserRight = "Swiss K-31 Schmidt Rubin 7.5x55 straight pull rifle".toLowerCase();

    @Test
    public void testJaccardDistance()
    {
        JaccardDistance jaccardDistance = new JaccardDistance();

        Assert.assertEquals("Expected 1.0", 1.0, jaccardDistance.compare(null, null), 0.0);
        Assert.assertEquals("Expected 0.0", 0.0,
            jaccardDistance.compare(StringInput.split("\\s+"), StringInput.split("\\s+")), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, jaccardDistance.compare(null, StringInput.split("\\s+")), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, jaccardDistance.compare(StringInput.split("\\s+"), null), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, jaccardDistance.compare(new String[0], new String[0]), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, jaccardDistance.compare("foo".split("\\s+"), null), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, jaccardDistance.compare("foo".split("\\s+"), new String[0]), 0.0);
        Assert.assertEquals("Expected 1.0", 1.0, jaccardDistance.compare(new String[0], "foo".split("\\s+")), 0.0);
        Assert.assertEquals("Expected 0.8588957055214724", 0.8588,
            jaccardDistance.compare(DescriptionLeft.split("\\s+"), DescriptionRight.split("\\s+")), 0.0001);
        Assert.assertEquals("Expected 0.9347826086956522", 0.9347,
            jaccardDistance.compare(DescriptionLeft.split("\\s+"), DescriptionDifferent.split("\\s+")), 0.0001);
        Assert.assertEquals("Expected 0.4444444444444444", 0.4444,
            jaccardDistance.compare(CloserLeft.split("\\s+"), CloserRight.split("\\s+")), 0.0001);
    }
}
