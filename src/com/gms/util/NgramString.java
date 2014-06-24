/*
 * Ngram.java
 *
 * Copyright 2014 George M. Stragand III.  All Rights Reserved.
 */
package com.gms.util;

import java.util.ArrayList;
import java.util.Collection;

public class NgramString
{
    private final int ngramSize;

    public NgramString(final int ngramSize)
    {
        this.ngramSize = ngramSize;
    }

    public String[] buildNgram(String input)
    {
        return buildNgram(input.split("\\s+"));
    }

    public String[] buildNgram(String[] input)
    {
        Collection<String> output = new ArrayList<String>();
        StringBuffer buffy = new StringBuffer();
        for (int i = 0; i < input.length + 1 - ngramSize; i++)
        {
            buffy.setLength(0);
            for (int j = 0; j < ngramSize; j++)
            {
                buffy.append(input[i + j]).append(" ");
            }
            output.add(buffy.toString().trim());
        }
        return output.toArray(new String[0]);
    }
}
