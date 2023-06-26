package uy.edu.um.prog2.adt.Heap;

public interface MyHeap<K extends Comparable<K>, V> {
    void insert(K key, V value);
    Pair<K, V> removeMax();
    boolean isEmpty();
    int size();
}