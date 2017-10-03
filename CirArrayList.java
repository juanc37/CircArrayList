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
 * @author Juan Candelaria Claborne, cssc0247
 */
public final class CirArrayList<E> extends AbstractList<E> implements
        List<E>, RandomAccess {
    private int currentSize;
    private int maxSize;
    private int front;
    private int rear;
    private final int DEFAULT_SIZE = 100;


    private E[] storage;

    /**
     * Builds a new, empty CirArrayList.
     */
    public CirArrayList() {
        front = rear = currentSize = 0;
        maxSize = DEFAULT_SIZE;
        storage = new E[DEFAULT_SIZE];
    }

    /**
     * Constructs a new CirArrayList containing all the items in the input
     * parameter.
     *
     * @param col the Collection from which to base
     */
    public CirArrayList(Collection<? extends E> col) {
        // todo: collection constructor
        front = rear = currentSize = 0;
        maxSize = DEFAULT_SIZE;
        int i = 0;
        storage = new E[DEFAULT_SIZE];
        for(E thing : col){
            storage[i] = thing;
        }
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
        if (index >= currentSize || index < 0){
            throw new IndexOutOfBoundsException();
            return;
        }
        if (front < rear)
            return storage[front+index];
        if (rear < front)
            return storage[(front+index)-maxSize];
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
        if (index >= currentSize || index < 0){
            throw new IndexOutOfBoundsException();
            return;
        }
        if (front < rear){
            E item = storage[front+index];
            storage[front+index] = value;
            return item;
        }
        if (rear < front){
            E item = storage[(front+index)-maxSize];
            storage[(front+index)-maxSize] = value;
            return item;
        }
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
            return;
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
        if (front < rear){
            if (rear == maxSize-1){
                storage[0] = storage[rear];
                rear = 0;
                for (int i = maxSize-1; i > front+index; i--)
                    storage[i] = storage[i-1];
                storage[front+index] = value;
            }
            else {
                for (int i = rear+1; i > front+index; i--)
                    storage[i] = storage[i-1];
                storage[front+index] = value;
                rear++;
            }
        }
        if (rear < front){
            //todo: ask healey about this algorithm for checking
            if (front+index >= maxSize){
                //only shift after 0
                for (int i = rear+1; i > ((front+index)-maxSize); i--)
                    storage[i] = storage[i-1];
                storage[(front+index)-maxSize] = value;
            }
            else{
                //shif front and then back
                for (int i = rear+1; i > 0; i--)
                    storage[i] = storage[i-1];
                storage[0] = storage[maxSize-1];
                for (int i = maxSize-1; i > front+index; i--)
                    storage[i] = storage[i-1];
                storage[front+index] = value;
            }
            rear++;
        }
        currentSize++;
    }

    /**
     * Inserts the specified element at the front of this list.
     *
     * @param value element to be inserted
     */
    private void addFront(E value) {
        //doesnt need to check for empty list because addrear handles it
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
    }

    /**
     * Inserts the specified element at the rear of this list.
     *
     * @param value element to be added
     */
    private void addRear(E value) {
        if (currentSize == 0){
            storage[rear] = value;
            currentSize++;
            return;
        }
        if (rear != maxSize-1){
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
        if (index >= currentSize || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if (currentSize < (maxSize/4))
            if (currentSize != 0)
                resize(0);
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
        if (front < rear)
            if (rear < front)
    }

    /**
     * removes the element at the front of this list.
     *
     * @return element that was removed
     */
    private E removeFront() {
        if (front != maxSize-1){
            E item = storage[front];
            front++;
            currentSize--;
            return item;
        }
        else {
            E item = storage[front];
            front = 0;
            currentSize--;
            return item;
        }
    }

    /**
     * removes the element at the rear of this list.
     *
     * @return element that was removed
     */
    private E removeRear() {
        //todo: code such that you can remove from rear and account for wrapping
        if (rear != 0){
            E item = storage[rear];
            rear--;
            currentSize--;
            return item;

        }
        else {
            E item = storage[rear];
            rear = maxSize-1;
            currentSize--;
            return item;
        }
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
        //make sure that if the list is empty that it doesnt freak
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