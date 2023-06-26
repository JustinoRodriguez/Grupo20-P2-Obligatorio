package uy.edu.um.prog2.adt.Hash;

import uy.edu.um.prog2.adt.LinkedList.MyLinkedList;

public interface MyHashTable<K,T>{
    void put(K key, T data);
    T get(K key);
    void remove(K key);
    MyLinkedList<K> keys();

    int size();
    boolean contains(K key);

}
