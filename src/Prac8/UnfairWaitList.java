package Prac8;

public class UnfairWaitList<E> extends WaitList<E>{
    WaitList<E> deleted;
    public UnfairWaitList(){
        super();
        deleted = new WaitList<>();
    }
    public void remove(E n){
        if(!content.element().equals(n)) {
            content.remove(n);
            deleted.add(n);
        }
    }
    public void moveToBack(E n){
        if(contains(n)){
            remove(n);
            content.add(n);
        }
    }

    @Override
    public void add(E n) {
        if(!deleted.contains(n))
            content.add(n);
    }
}
