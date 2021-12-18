package Prac8;

import java.util.Collection;

public interface IWaitList<E> {
    public void add(E n);
    public E remove();
    public boolean contains(E n);
    public boolean containsAll(Collection<E> c);
    public boolean isEmpty();
}
