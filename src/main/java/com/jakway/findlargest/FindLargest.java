package com.jakway.findlargest;

import java.util.Collection;
import java.util.Iterator;

public class FindLargest
{
    public static Collection<Integer> processStream(int n, Iterator<Integer> it)
    {
        BoundedPriorityQueue<Integer> queue = new BoundedPriorityQueue<Integer>(n);

        if(!it.hasNext())
        {
            throw new RuntimeException("iterator is empty!");
        }

        Integer thisItem = null;

        //the BoundedPriorityQueue will check internally whether or not to add
        //the passed item
        while(it.hasNext())
        {
            thisItem = it.next();
            queue.add(thisItem);
        }

        return queue.getCollection();
    }
}
