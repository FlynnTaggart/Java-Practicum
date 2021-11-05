package Lab9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner myScanner = new Scanner( System.in );
//        System.out.print( "Enter an integer ");
//        String intString = myScanner.next();
//        try {
//            int i = Integer.parseInt(intString);
//            System.out.println(2 / i);
//        }
//        catch (NumberFormatException e){
//            System.out.println("Wrong number format");
//        }
//        catch (ArithmeticException e){
//            System.out.println("Attempted division by zero");
//        }
//        catch (Exception e){
//            System.out.println("Something went wrong");
//        }
//        finally {
//            System.out.println("Finally");
//        }
        ThrowsDemo throwsDemo = new ThrowsDemo();
        throwsDemo.getKey();
    }
}
