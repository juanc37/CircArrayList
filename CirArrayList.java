package CirArray;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/**
 * A circular version of an array list.
 * <p>Operates as a standard java.util.ArrayList, but additions and removals
 * from the List's front occur in constant time, for its circular nature
 * eliminates the shifting required when adding or removing elements to the
 * front of the ArrayList.
 * </p>
 *
 * @author Juan Candelaria Claborne
 */
public final class CirArrayList<E> extends AbstractList<E> implements
        List<E>, RandomAccess {
    private int currentSize;
    private int gg;
    private int maxSize;
    private int front;
    private int rear;
    private final int DEFAULT_SIZE = 100;


    private E[] storage;

    /**
     * Builds a new, empty CirArray.CirArrayList.
     */
    public CirArrayList() {
        storage = new E[DEFAULT_SIZE];
        front = rear = currentSize = 0;
        maxSize = DEFAULT_SIZE;

    }

    /**
     * Constructs a new CirArray.CirArrayList containing all the items in the input
     * parameter.
     *
     * @param col the Collection from which to base
     */
    public CirArrayList(Collection<? extends E> col) {
        // todo: collection constructor
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index (0 based) of the element to return.
     * @return element at the specified position in the list.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0
     *                                   || index >= size())
     */
    @Override
    public E get(int index) {
        // todo: Students must code
        if (front > rear)
            if (rear > front)
                if (rear == front)
                    return null;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param value element to be stored at teh specified position
     * @return element previously at the specified position
     * @throws IndexOutOfBoundsException if index is out of the range (index < 0
     *                                   || index >= size())
     */
    @Override
    public E set(int index, E value) {
        // todo: Students must code
        if (front > rear)
            if (rear > front)
                if (rear == front)
                    return null;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param value element to be inserted
     */
    @Override
    public void add(int index, E value) {
        // todo: Students must code
        if (index < 0 || index > currentSize){
            throw new IndexOutOfBoundsException();
        }
        if (isFull())
            resize(1);
        if (index != currentSize && index != 0)
            insert(index, value);
        else if (index == currentSize)
            addRear(value);
        else if (index == 0)
            addFront(value);
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param value element to be inserted
     */
    private void insert(int index, E value) {
        if (front > rear)
            if (rear > front)
                if (rear == front)
                    System.out.println("ERROR");
    }

    /**
     * Inserts the specified element at the front of this list.
     *
     * @param value element to be inserted
     */
    private void addFront(E value) {
        if (front != 0){
            front--;
            storage[front] = value;
            currentSize++;
            return;
        }
        else {
            front = maxSize-1;
            storage[front] = value;
            currentSize++;
        }
        System.out.println("ERROR");
    }

    /**
     * Inserts the specified element at the rear of this list.
     *
     * @param value element to be added
     */
    private void addRear(E value) {
        if (rear != maxSize){
            rear++;
            storage[rear] = value;
            currentSize++;
            return;
        }
        else {
            rear = 0;
            storage[rear] = value;
            currentSize++;
        }
        System.out.println("ERROR");
    }

    /**
     * Removes the element at the specified position in this list.  Shifts
     * any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index index of element to remove
     * @return the element previously at the specified position.
     */
    @Override
    public E remove(int index) {
        // todo: Students must code
        if (currentSize < (maxSize/4))
            resize(0);
        if (index >= currentSize){
            throw new IndexOutOfBoundsException;
            return;
        }
        if (index != 0 && index != currentSize-1)
        return removeFromMiddle(index);
        else if (index == 0)
            return removeFront();
        else if (index == currentSize-1)
            return removeRear();
        return null;
    }

    /**
     * Removes the element at the specified position in this list. Shifts
     * any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index index of element to remove
     * @return the element previously at the specified position.
     */
    private E removeFromMiddle(int index) {
        //todo: code such that you can insert a value at an index and shif
        // the rest of the list elements over
        if (front > rear)
            if (rear > front)
                if (rear == front)
                    System.out.println("ERROR");
    }

    /**
     * removes the element at the front of this list.
     */
    private E removeFront() {
        //todo: code such that you can remove from front and account for wrapping
        //todo: make sure that
        if (front != maxSize){
            front++;
            currentSize--;
        }
        else {
            front = 0;
            currentSize--;
        }
        System.out.println("ERROR");

    }

    /**
     * removes the element at the rear of this list.
     */
    private E removeRear() {
        //todo: code such that you can remove from rear and account for wrapping

        System.out.println("ERROR");

    }

    /**
     * Resizes the array by 50% either way depending on if the list is being
     * added to (increase size) or removed from(decrease size).
     *
     * @param scale tells the method whether it should scale the list up
     * or down 1 yielding a bigger container and 0 yielding a smaller one
     */
    private void resize(int scale){
        //todo: code such that scale = 1 increases size by 50% and
        //scale = 1 decrases size by 50%
    }

    /**
     * Reports the number of items in the List.
     *
     * @return the item count.
     */
    @Override
    public int size() {
        return currentSize;
    }

    /**
     * Checks to see if the container is full by comparing maxSize to
     * currentSize
     *
     * @return true if container is full and false if it is not
     */
    private boolean isFull(){
        return (currentSize == maxSize);
    }
}