package CirArray;

import java.util.*;

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

    /**
     * Returns an iterator over the elements in this collection. The iterator
     * produces results in the order in which they would appear were one to
     * successively poll the queue.
     *
     * @return an Iterator over the elements in this queue.
     */
    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    /**
     * Reports the number of items in this queue.
     *
     * @return the number of items in this queue.
     * @implNote it is INCORRECT to track this as a field in this class.
     */
    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}