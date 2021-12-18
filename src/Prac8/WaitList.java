package Prac8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitList<E> implements IWaitList<E>{
    protected ConcurrentLinkedQueue<E> content;
    public WaitList() {
        content = new ConcurrentLinkedQueue<>();
    }

    /**
     *
     * @param c
     */
    public WaitList(Collection<E> c) {
        content = new ConcurrentLinkedQueue<>(c);
    }

    @Override
    public void add(E n) {
        content.add(n);
    }

    @Override
    public E remove() {
        return content.remove();
    }

    @Override
    public boolean contains(E n) {
        return content.contains(n);
    }

    @Override
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }

    @Override
    public String toString() {
        return "WaitList{" +
                "content=" + content +
                '}';
    }
}
