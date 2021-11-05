package Lab10;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static <E> ArrayList<E> ArrayToArrayList(E[] a){
        return new ArrayList<>(Arrays.asList(a));
    }

    public static void fileList(String path){
        File file = new File(path);
        String[] fileArray = null;
        if (file.exists() || file.isDirectory())
            fileArray = file.list(null);
        else
            System.out.print("Wrong path");
        ArrayList<String> fileList = ArrayToArrayList(fileArray);

        if(fileList.size() >= 5)
            for(int i = 0; i < 5; ++i){
                System.out.println(fileList.get(i));
            }
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

        fileList("C:\\Users\\mr130\\IdeaProjects");
    }
}
