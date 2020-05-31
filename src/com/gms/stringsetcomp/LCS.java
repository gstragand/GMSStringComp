/*
 * LCS.java
 *
 * Copyright 2014 George M. Stragand III.  All Rights Reserved.
 */
package com.gms.stringsetcomp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Longest Common Subsequence measures the similarity between sets of strings. A result of 0.0 (no distance) are equal
 * sets.
 */
public class LCS
{
    public double compare(final String[] left, final String[] right)
    {
        return ((null != left && null != right) && (left.length > 0 || right.length > 0)) ? dissimilarity(
            Arrays.asList(left), Arrays.asList(right)) : 1.0;
    }

    private double dissimilarity(final List<String> left, final List<String> right)
    {
        final int lSize = left.size();
        final int rSize = right.size();
        final int[][] lengths = new int[lSize + 1][rSize + 1];

        for (int i = 0; i < lSize; i++)
            for (int j = 0; j < rSize; j++)
                if (left.get(i).equals(right.get(j)))
                    lengths[i + 1][j + 1] = lengths[i][j] + 1;
                else
                    lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);

        List<String> result = new ArrayList<>();
        for (int i = lSize, j = rSize; i != 0 && j != 0;)
        {
            if (lengths[i][j] == lengths[i - 1][j])
                i--;
            else if (lengths[i][j] == lengths[i][j - 1])
                j--;
            else
            {
                result.add(left.get(i - 1));
                i--;
                j--;
            }
        }

        return 1.0 - (2.0 * result.size()) / (lSize + rSize);
    }
}
