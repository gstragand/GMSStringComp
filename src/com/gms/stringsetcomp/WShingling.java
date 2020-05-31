/*
 * WShingling.java
 *
 * Copyright 2014 George M. Stragand III.  All Rights Reserved.
 */
package com.gms.stringsetcomp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gms.util.NgramString;

/**
 * WShingling measures the similarity between sets of strings. A result of 0.0 (no distance) are equal sets.
 */
public class WShingling
{
    private final NgramString ngram;
    private final int shingleSize;

    public WShingling(final int shingleSize)
    {
        this.ngram = new NgramString(shingleSize);
        this.shingleSize = shingleSize;
    }

    public double compare(final String[] left, final String[] right)
    {
        return ((null != left && null != right) && (left.length >= shingleSize || right.length >= shingleSize)) ? dissimilarity(
            left, right) : 1.0;
    }

    private double dissimilarity(final String[] left, final String[] right)
    {
        List<String> leftNgram = Arrays.asList(ngram.buildNgram(left));
        List<String> rightNgram = Arrays.asList(ngram.buildNgram(right));

        Set<String> intersection = new HashSet<>(leftNgram);
        intersection.retainAll(rightNgram);

        Set<String> union = new HashSet<>(leftNgram);
        union.addAll(rightNgram);

        return 1.0 - ((double) intersection.size() / union.size());
    }
}
