package Lab12.Task5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?=.*[a-z].*)(?=.*[A-Z].*)(?=.*\\d.*).\\w{7,}");
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            System.out.println("Correct");
            return;
        }
        System.out.println("Incorrect");
    }
}
