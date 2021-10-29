package Lab7;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        System.out.println(a);
        a.remove(3);
        System.out.println(a);
        System.out.println(a.contains(6));
        a.set(0, 101);
        System.out.println(a.get(0));
        a.addAll(Arrays.asList(new Integer[]{1337, 501, 4654, 123}));
        System.out.println(a);
    }
}