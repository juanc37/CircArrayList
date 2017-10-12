package CirArray;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class ArrayPriorityQueue<E extends Comparable<? extends E>>
        extends AbstractCollection<E> implements Queue<E> {

    private List<E> queue;

    /**
     * Builds a new, empty priority queue.
     */
    public ArrayPriorityQueue() {
        super();
        queue = new CirArrayList<>();
    }

    /**
     * Builds a new priority queue containing every item in the provided
     * collection.
     *
     * @param col the Collection containing the objects to add to this queue.
     */
    public ArrayPriorityQueue(Collection<? extends E> col) {
        super();
        queue = new CirArrayList<>(col);
    }
