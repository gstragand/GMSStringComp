/*
 * JaccardDistance.java
 *
 * Copyright 2014 George M. Stragand III.  All Rights Reserved.
 */
package com.gms.stringsetcomp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * JaccardDistance measures the similarity between sets of strings. A result of 0.0 (no distance) are equal sets.
 */
public class JaccardDistance
{
    public double compare(String[] left, String[] right)
    {
        return ((null != left && null != right) && (left.length > 0 || right.length > 0)) ? dissimilarity(
            Arrays.asList(left), Arrays.asList(right)) : 1.0;
    }

    private double dissimilarity(List<String> left, List<String> right)
    {
        Set<String> union = new HashSet<String>(left);
        union.addAll(right);

        Set<String> intersection = new HashSet<String>(left);
        intersection.retainAll(right);

        return 1.0 - ((double) intersection.size() / union.size());
    }
}
