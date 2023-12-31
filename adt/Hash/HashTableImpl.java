package uy.edu.um.prog2.adt.Hash;

import uy.edu.um.prog2.adt.LinkedList.*;

public class HashTableImpl<K,T> implements MyHashTable<K,T> {

    private HashNode<K, T>[] hash;
    private int size;

    public HashTableImpl(int length) {
        this.hash = new HashNode[length];
        this.size = 0;
    }

    @Override
    public void put(K key, T data) {
        int attempt = 0;
        int index = linearIndex(key, attempt);
        while (this.hash[index] != null && !this.hash[index].isDeleted() && attempt <= this.size) {
            attempt++;
            index = linearIndex(key, attempt);
        }
        if (attempt > size) {
            throw new RuntimeException("uy.edu.um.prog2.adt.Hash lleno");
        }
        HashNode<K, T> toAdd = new HashNode<>(key, data);
        this.hash[index] = toAdd;
        size++;
    }

    private int linearCollision(int attempt) {
        return attempt;
    }

    private int linearIndex(K key, int attempt) {
        return Math.abs(key.hashCode() + linearCollision(attempt)) % this.hash.length;
    }

    @Override
    public T get(K key) {
        int attempt = 0;
        int index = linearIndex(key, attempt);
        boolean found = false;
        while (this.hash[index] != null && attempt <= this.size && !found) {
            if (!this.hash[index].getKey().equals(key)) {
                attempt++;
                index = linearIndex(key, attempt);
            } else {
                found = true;
            }
        }
        if (found && !this.hash[index].isDeleted()) {
            return this.hash[index].getData();
        } else {
            throw new RuntimeException("No se encuentra el elemento");
        }

    }

    @Override
    public void remove(K key) {
        int attempt = 0;
        int index = linearIndex(key, attempt);
        boolean found = false;
        while (this.hash[index] != null && attempt <= this.size && !found) {
            if (!this.hash[index].getKey().equals(key)) {
                attempt++;
                index = linearIndex(key, attempt);
            } else {
                found = true;
            }
        }
        if (found && !this.hash[index].isDeleted()) {
            this.hash[index].setDeleted(true);
            this.size--;
        } else {
            throw new RuntimeException("No se encuentra el elemento");
        }
    }

    @Override
    public MyLinkedList<K> keys() {
        MyLinkedList<K> keys = new MyLinkedListImpl<>();
        int index = 0;
        while (keys.size() < this.size && index < this.hash.length) {
            if (this.hash[index] != null && !this.hash[index].isDeleted()) {
                keys.add(this.hash[index].getKey());
            }
            index++;
        }
        return keys;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(K key) {
        try {
            this.get(key);
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }
}

