package Lab12.Task2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d\\s*\\+");
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.find());
    }
}
