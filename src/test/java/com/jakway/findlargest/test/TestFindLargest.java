package com.jakway.findlargest.test;

import org.junit.*;

import com.jakway.findlargest.FindLargest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestFindLargest
{
    private List<Integer> decreasingStream,
                          increasingStream;

    @Before
    public void setUp()
    {
        decreasingStream = new ArrayList<Integer>();
        increasingStream = new ArrayList<Integer>();

        final int largeStreamSize = 1000;
        for(int i = largeStreamSize; i > 0; i--)
        {
            decreasingStream.add(Integer.valueOf(i));
        }

        for(int i = 0; i < largeStreamSize; i++)
        {
            increasingStream.add(Integer.valueOf(i));
        }
    }


    /**
     * @return an array of the largest n integers in the list
     */
    private static Integer[] largestInts(int n, List<Integer> list)
    {
        //if the number of largest ints we want is greater than the number of ints
        //in the first place, just return them
        if(n >= list.size())
        {
            return list.toArray(new Integer[n]);
        }

        //Collections.sort modifies in-place, copy the passed list to avoid
        //side effects
        List<Integer> sortedList = new ArrayList<Integer>(list);
        Collections.sort(sortedList);

        Integer[] largestIntArray = new Integer[n];
        for(int i = sortedList.size()-1; i >= n; i--)
        {
            largestIntArray[i] = sortedList.get(n);
        }

        return largestIntArray;
    }

    @Test
    public void testWorstCase()
    {
        //how many integers do we want to find?
        final int n = 10;

        final Collection<Integer> largestIntCollection = FindLargest.processStream(n, increasingStream.iterator());
        final Integer[] largestIntArray = largestIntCollection.toArray(new Integer[largestIntCollection.size()]);


        //independently get the largest integers from the stream
        //check these against the output
        final Integer[] knownLargestInts = largestInts(n, increasingStream);

        assertArrayEquals(knownLargestInts, largestIntArray);
    }
}
