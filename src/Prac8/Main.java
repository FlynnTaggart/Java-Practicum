package Prac8;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        WaitList<Integer> l1 = new WaitList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        System.out.println(l1);
        l1.remove();
        l1.remove();
        System.out.println(l1 + "\n");
        BoundedWaitList<String> l2 = new BoundedWaitList<>(3);
        l2.add("one");
        l2.add("two");
        l2.add("three");
        l2.add("four");
        System.out.println(l2 + "\n");
        UnfairWaitList<Integer> l3 = new UnfairWaitList<>();
        l3.add(1);
        l3.add(2);
        l3.add(3);
        l3.add(4);
        l3.add(5);
        l3.add(3);
        l3.add(6);
        l3.add(1);
        l3.add(6);
        System.out.println(l3);
        l3.remove(1);
        System.out.println(l3);
        l3.remove(3);
        System.out.println(l3);
        l3.moveToBack(2);
        System.out.println(l3);
        l3.add(3);
        System.out.println(l3);
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(5);
        testList.add(3);
        testList.add(6);
        System.out.println(l3.containsAll(testList));
    }
}
