package Prac8;

public class BoundedWaitList<E> extends WaitList<E>{
    private int capacity;

    /**
     *
     * @param capacity
     */
    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void add(E n) {
        if(content.size() < capacity)
            content.add(n);
    }

    @Override
    public String toString() {
        return "BoundedWaitList{" +
                "capacity=" + capacity + ", content=" + content +
                '}';
    }
}
