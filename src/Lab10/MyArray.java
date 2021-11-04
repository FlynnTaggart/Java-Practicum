package Lab10;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray<E> {
    private E[] data;

    public MyArray(E[] data) {
        this.data = data;
    }


    public E get(int index){
        return data[index];
    }
}
