package com.jakway.findlargest;

import java.util.Collection;
import java.util.Iterator;

public class FindLargest
{
    static Collection<Integer> processStream(int n, Iterator<Integer> it)
    {
        BoundedPriorityQueue<Integer> queue = new BoundedPriorityQueue<Integer>(n);

        if(!it.hasNext())
        {
            throw new RuntimeException("iterator is empty!");
        }

        Integer thisItem = it.next();

        //use a do-while loop in case the stream only has 1 integer
        do
        {
            queue.add(thisItem);

            it.next();
        }
        while(it.hasNext());

        return queue.getCollection();
    }

    public static void main(String[] args)
    {

    }
}
