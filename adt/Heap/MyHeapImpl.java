package uy.edu.um.prog2.adt.Heap;
import java.util.Arrays;

public class MyHeapImpl<K extends Comparable<K>, V> implements MyHeap<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private Pair<K, V>[] heapArray;
    private int size;

    public MyHeapImpl() {
        this(DEFAULT_CAPACITY);
    }

    public MyHeapImpl(int capacity) {
        heapArray = new Pair[capacity];
        size = 0;
    }

    public void insert(K key, V value) {
        if (size == heapArray.length) {
            resizeArray();
        }

        Pair<K, V> pair = new Pair<>(key, value);
        heapArray[size] = pair;
        heapifyUp(size);
        size++;
    }

    public Pair<K, V> removeMax() {
        if (isEmpty()) {
            throw new IllegalStateException("uy.edu.um.prog2.adt.Heap is empty");
        }

        Pair<K, V> maxPair = heapArray[0];
        swap(0, size - 1);
        heapArray[size - 1] = null;
        size--;
        heapifyDown(0);
        return maxPair;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);
        while (index > 0 && compare(heapArray[index].getKey(), heapArray[parentIndex].getKey()) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    public void heapifyDown(int index) {
        while (true) {
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            int largestChildIndex = index;

            if (leftChildIndex < size && compare(heapArray[leftChildIndex].getKey(), heapArray[largestChildIndex].getKey()) > 0) {
                largestChildIndex = leftChildIndex;
            }

            if (rightChildIndex < size && compare(heapArray[rightChildIndex].getKey(), heapArray[largestChildIndex].getKey()) > 0) {
                largestChildIndex = rightChildIndex;
            }

            if (largestChildIndex == index) {
                break;
            }

            swap(index, largestChildIndex);
            index = largestChildIndex;
        }
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public void swap(int index1, int index2) {
        Pair<K, V> temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }

    public void resizeArray() {
        int newCapacity = heapArray.length * 2;
        heapArray = Arrays.copyOf(heapArray, newCapacity);
    }

    public int compare(K key1, K key2) {
        return key1.compareTo(key2);
    }
}

