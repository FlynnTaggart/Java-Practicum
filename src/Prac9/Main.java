package Prac9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your INN:");
        String INN = scanner.nextLine();
        Checker checker = new Checker(name);
        try {
            checker.enterINN(INN);
            System.out.println("Correct!");
        }
        catch (InvalidINNException e){
            System.out.println(e);
        }

    }
}
