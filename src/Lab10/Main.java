package Lab10;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static <E> ArrayList<E> ArrayToArrayList(E[] a){
        return new ArrayList<>(Arrays.asList(a));
    }



    public static void main(String[] args) {
        String[] s = new String[5];
        s[0] = "Lol";
        s[1] = "9";
        s[2] = "Lab";
        s[3] = "is";
        s[4] = "Exception";
        ArrayList<String> sList = ArrayToArrayList(s);
        System.out.println(sList);

        MyArray myArray = new MyArray(s);
        System.out.println(myArray.get(3));
    }
}
