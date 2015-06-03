/*
 * NameLevenshtein.java
 *
 * Copyright 2014 George M. Stragand III.  All Rights Reserved.
 */
package com.gms.strcomp;

import java.util.Arrays;

public class NameLevenshtein
        extends Levenshtein
{
    private static final String SPACE = " ";

    @Override
    public double compare(final String name1, final String name2)
    {
        return super.compare(tokenizeAndSort(name1), tokenizeAndSort(name2));
    }

    private static String tokenizeAndSort(final String name)
    {
        String[] arrayName = name.split(SPACE);
        Arrays.sort(arrayName);
        StringBuilder nameSorted = new StringBuilder(arrayName[0]);
        for (int i = 1; i < arrayName.length; i++)
        {
            nameSorted.append(SPACE).append(arrayName[i]);
        }
        return nameSorted.toString();
    }
}
