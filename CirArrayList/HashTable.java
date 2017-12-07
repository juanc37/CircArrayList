package CirArrayList;

import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<K extends Comparable<K>, V> implements MapADT<K, V> {
    private LinkedList<MapItem<K, V>>[] storage;
    //todo: make MapItem class
    private int currentSize;
    private int maxCapacity;
    private int sizeThreshold;
    private int[] primeSizeList = {23, 47, 97, 197, 397, 797, 1597, 3203, 6421, 12853,
            25717, 51437, 102877, 205759, 411527, 823117, 1646237, 3292489, 6584983,
            13169977, 26339969, 52679969, 105359939, 210719881, 421439783, 842879579};

    public HashTable() {
        storage = new LinkedList[primeSizeList[0]];
        for (int i = 0; i < storage.length; i++) {
            storage[i] = new LinkedList<>();
        }
        currentSize = 0;
        maxCapacity = primeSizeList[0];
        sizeThreshold = (int) (maxCapacity * .9);
    }

    public HashTable(MapADT toCopy) {
        this();
        Iterator k = toCopy.keys();
        Iterator v = toCopy.values();
        K key;
        V value;
        while (k.hasNext() && v.hasNext()) {
            key = (K) k.next();
            value = (V) v.next();
            add(key, value);
        }
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V add(K key, V value) {
        return null;
    }

    @Override
    public boolean delete(K key) {
        return false;
    }

    @Override
    public V getValue(K key) {
        return null;
    }

    @Override
    public K getKey(V value) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<K> keys() {
        return null;
    }

    @Override
    public Iterator<V> values() {
        return null;
    }
}