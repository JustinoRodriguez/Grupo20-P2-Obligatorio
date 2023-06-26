package uy.edu.um.prog2.adt.LinkedList;

public interface MyLinkedList<T> {
    void add(T value);

    void remove(int position);

    T get(int position);

    int size();
}
