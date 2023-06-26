package uy.edu.um.prog2.adt.LinkedList;

public class MyLinkedListImpl <T> implements MyLinkedList<T> {
    private Nodo<T> first;
    public MyLinkedListImpl() {
        this.first = null;
    }

    @Override
    public void add(T value) {
        if (this.first == null) {
            this.first = new Nodo<>(value);
        } else {
            Nodo<T> temp = this.first;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            Nodo<T> nodoAAgregar = new Nodo(value);
            temp.setNext(nodoAAgregar);
        }
    }

    @Override
    public void remove(int position) {
        if (position == 0) {
            Nodo<T> siguiente = this.first.getNext();
            this.first = siguiente;

        } else {
            int counter = 0;
            Nodo<T> temp = this.first;
            while (counter < position - 1) {

                try {
                    temp = temp.getNext();
                } catch (NullPointerException e) {
                    System.out.println("Indice incorrecto");
                    return;
                }
                counter++;
            }
            try {
                Nodo<T> t = temp.getNext().getNext();
                temp.setNext(t);
            } catch (NullPointerException e) {
                System.out.println("Indice incorrecto");
            }


        }

    }
    @Override
    public T get(int position) {
        T value = null;
        if (this.first != null) {
            if (position == 0) {
                value = this.first.getValue();
                return value;
            } else {
                int cont = 0;
                Nodo<T> temp = this.first;
                while (cont < position && temp != null) {
                    temp = temp.getNext();
                    cont++;
                }
                if (temp != null) {
                    value = temp.getValue();
                }

                return value;

            }

        } else {
            return null;
        }
    }
    @Override
    public int size() {
        int count = 0;
        Nodo<T> temp = this.first;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }


}

