/*
 * Dice.java
 *
 * Copyright 2014 George M. Stragand III.  All Rights Reserved.
 */
package com.gms.strcomp;

import java.util.ArrayList;
import java.util.List;

public class Dice
{
    public double compare(String str1, String str2)
    {
        return dice(bigram(str1), bigram(str2));

    }

    private double dice(List<char[]> bigram1, List<char[]> bigram2)
    {
        List<char[]> copy = new ArrayList<>(bigram2);
        int matches = 0;
        for (int i = bigram1.size(); --i >= 0;)
        {
            char[] bigram = bigram1.get(i);
            for (int j = copy.size(); --j >= 0;)
            {
                char[] toMatch = copy.get(j);
                if (bigram[0] == toMatch[0] && bigram[1] == toMatch[1])
                {
                    copy.remove(j);
                    matches += 2;
                    break;
                }
            }
        }
        return (double) matches / (bigram1.size() + bigram2.size());
    }

    private List<char[]> bigram(String input)
    {
        List<char[]> bigram = new ArrayList<>();
        for (int i = 0; i < input.length() - 1; i++)
        {
            char[] chars = new char[2];
            chars[0] = input.charAt(i);
            chars[1] = input.charAt(i + 1);
            bigram.add(chars);
        }
        return bigram;
    }
}
