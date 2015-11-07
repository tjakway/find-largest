package com.jakway.findlargest;

import java.util.Collection;
import java.util.PriorityQueue;

/**
 * note that Integer already implements Comparable<Integer>
 */
public class BoundedPriorityQueue<T extends Comparable<T>>
{
    //preferring to compose rather than inherit
    private PriorityQueue<T> queue;
    private int limit_size;


    public BoundedPriorityQueue(int limit_size)
    {
        if(limit_size <= 0)
        {
            throw new RuntimeException("Queue size must be >0");
        }
        this.limit_size = limit_size;
        queue = new PriorityQueue<T>(limit_size);
    }

    public void add(T item)
    {
        T smallest = queue.peek();
        if(smallest == null)
        {
            queue.add(item);
        }
        //compareTo returns >0 if item is larger than smallest
        else if(smallest.compareTo(item) > 0)
        {
            //adding the item to the PriorityQueue will reorder it so the now smallest item is at the head
            queue.add(item);

            if(queue.size() > limit_size)
            {
                //remove the item at the head to balance , it's now the smallest one
                queue.poll();
            }
        }
        checkInvariants();
    }

    public Collection<T> getCollection()
    {
        return queue;
    }

    public void checkInvariants()
    {
        assert(queue != null);
        assert(queue.size() <= limit_size);
    }
}
