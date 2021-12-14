package Prac13and14.Task5;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        long start_time = System.nanoTime();
        arrayList.add(1); arrayList.add(2); arrayList.add(3); arrayList.add(4); arrayList.add(5);
        long estimated_time = System.nanoTime() - start_time;
        System.out.println("insert 5 elements in ArrayList " + estimated_time+ " ns");
        start_time = System.nanoTime();
        linkedList.add(1); linkedList.add(2); linkedList.add(3); linkedList.add(4); linkedList.add(5);
        estimated_time = System.nanoTime() - start_time;
        System.out.println("insert 5 elements in LinkedList " + estimated_time+ " ns\n");

        start_time = System.nanoTime();
        arrayList.remove(2);
        estimated_time = System.nanoTime() - start_time;
        System.out.println("delete element in ArrayList " + estimated_time+ " ns");
        start_time = System.nanoTime();
        linkedList.remove(2);
        estimated_time = System.nanoTime() - start_time;
        System.out.println("delete element in LinkedList " + estimated_time+ " ns\n");

        start_time = System.nanoTime();
        arrayList.indexOf(3);
        estimated_time = System.nanoTime() - start_time;
        System.out.println("getting element in ArrayList " + estimated_time+ " ns");
        start_time = System.nanoTime();
        linkedList.indexOf(3);
        estimated_time = System.nanoTime() - start_time;
        System.out.println("getting element in LinkedList " + estimated_time + " ns\n");
    }
}
