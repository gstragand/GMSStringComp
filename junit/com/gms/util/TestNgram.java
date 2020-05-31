package com.gms.util;

import org.junit.Assert;
import org.junit.Test;

public class TestNgram
{
    private static final String SHORTTEST = "The quick brown fox";
    private static final String PLUSTWO = SHORTTEST + " ran fast";

    @Test
    public void testNgram()
    {
        NgramString ngram = new NgramString(4);

        Assert.assertEquals("Expected 1", 1, ngram.buildNgram(SHORTTEST).length);
        Assert.assertEquals("Expected 3", 3, ngram.buildNgram(PLUSTWO).length);
    }
}
