package Lab11;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(6);
        a.add(1);
        a.add(1);
        a.add(8);
        System.out.println(Solution.newHashSet(a));
        System.out.println(Solution.newArrayList(Solution.newHashSet(a)));
        ArrayList<String> b = new ArrayList<>();
        b.add("asdasd");
        b.add("56456");
        b.add("dfgdfg");
        b.add("dfgdfg");
        b.add("ayuiyiu");
        System.out.println(Solution.newHashMap(a, b));
    }
}
