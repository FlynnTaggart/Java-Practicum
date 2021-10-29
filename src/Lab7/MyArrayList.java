package Lab7;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> {
    private Object[] elements;
    private int size = 0;
    private int capacity = 0;

    public MyArrayList() {
        elements = new Object[10];
        size = 10;
        capacity = 0;
    }

    public MyArrayList(int size) {
        this.size = size;
        elements = new Object[size];
        capacity = 0;
    }

    public MyArrayList(Collection<? extends E> col) {
        Object[] a = col.toArray();
        size = col.size();
        capacity = size;
        elements = new Object[size];
        System.arraycopy(a, 0, elements, 0, size);
    }

    public int size(){
        return capacity;
    }

    void add(E e){
        if(capacity + 1 > size) {
            Object[] tempElements = new Object[size * 2];
            System.arraycopy(elements, 0, tempElements, 0, capacity);
            elements = tempElements;
        }
        elements[capacity++] = e;
    }

    boolean addAll(Collection<? extends E> col){
        if(col.size() == 0)
            return false;
        if(capacity + col.size() > size){
            Object[] tempElements = new Object[size + col.size()];
            System.arraycopy(elements, 0, tempElements, 0, capacity);
            elements = tempElements;
        }
        Object[] a = col.toArray();
        System.arraycopy(a, 0, elements, capacity, col.size());
        capacity += col.size();
        return true;
    }

    public E get(int index){
        return (E) elements[index];
    }

    public E set(int index, E e){
        elements[index] = e;
        return e;
    }

    public E remove(int index){
        E e = get(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        capacity--;
        return e;
    }

    public boolean contains(E e){
        for(int i = 0; i < capacity; ++i){
            if(e.equals(elements[i]))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < capacity; ++i){
            s += elements[i].toString() + ", ";
        }
        return s;
    }
}