package Prac15and16.Orders;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CycleLinkedList<E> implements Iterable<E> {
    private Node head;
    private int size;

    private class Node {
        private Node next = null;
        private Node prev = null;
        private E value = null;

        public Node() {}

        Node(Node next, Node prev, E value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }

    CycleLinkedList() {
        this.head = new Node();
        this.head.next = this.head.prev = this.head;
    }

    CycleLinkedList(Collection<? extends E> list) {
        this();
        addAll(list);
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorLinked();
    }

    private class IteratorLinked implements Iterator<E> {
        private Node current = head.next;

        @Override
        public boolean hasNext() {
            return current != head;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Elements not found...");
            }
            E value = current.value;
            current = current.next;
            return value;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private Node getNodeByIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Incorrect index");
        }
        Node resultNode = null;
        int half = this.size / 2;
        int count = half > index ? index : this.size - index - 1;
        for (Node node = (half > index ? this.head.next : this.head.prev); node != this.head; node = (half > index ? node.next : node.prev)) {
            if (count-- == 0) {
                resultNode = node;
                break;
            }
        }
        return resultNode;
    }

    private Node getNodeByValue(E value) throws IndexOutOfBoundsException{
        return getNodeByIndex(indexOf(value));
    }


    public void clear() {
        this.head = new Node();
        this.head.next = this.head.prev = this.head;
        this.size = 0;
    }

    public void add(E value) {
        addLast(value);
    }

    public void addFirst(E value) {
        if (value != null) {
            Node first = new Node(this.head.next, this.head, value);
            this.head.next = this.head.next.prev = first;
            this.size++;
        }
    }

    public void addLast(E value) {
        if (value != null) {
            Node last = new Node(this.head, this.head.prev, value);
            this.head.prev = this.head.prev.next = last;
            this.size++;
        }
    }

    public void addAll(Collection<? extends E> list) {
        for (E i : list)
            add(i);
    }

    public int indexOf(E value) {
        int index = 0;
        for(Node node = this.head.next; node != this.head; node = node.next){
            if(node.value.equals(value)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public E get(int index) {
        return getNodeByIndex(index).value;
    }

    public boolean remove(E value) throws IndexOutOfBoundsException{
       Node nodeForDelete = getNodeByValue(value);
       if (nodeForDelete != null) {
           nodeForDelete.prev.next = nodeForDelete.next;
           nodeForDelete.next.prev = nodeForDelete.prev;
           this.size--;
           return true;
       }
        return false;
    }

    public boolean remove(int index) {
        Node nodeForDelete = getNodeByIndex(index);
        if (nodeForDelete != null) {
            nodeForDelete.next.prev = nodeForDelete.prev;
            nodeForDelete.prev.next = nodeForDelete.next;
            this.size--;
            return true;
        }
        return false;
    }

    public E[] toArray() {
        E[] array = (E[]) new Object[this.size];
        int index = 0;
        for (Node node = this.head.next; node != this.head; node = node.next) {
            array[index++] = node.value;
        }
        return array;
    }

    public Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public void sort() {
        E[] elements = (E[]) stream().sorted().toArray();
        clear();
        Arrays.stream(elements).forEach(this::add);
    }

    public void sort(Comparator<? super E> c) {
        E[] elements = (E[]) stream().sorted(c).toArray();
        clear();
        Arrays.stream(elements).forEach(this::add);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }

}
