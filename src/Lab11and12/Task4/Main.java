package Lab11and12.Task4;

public class Main {
    public static void main(String[] args) {
        NumberChecker numberChecker = new NumberChecker("+79852267261");
        System.out.println(numberChecker);
        numberChecker.parseNumber("89861321233");
        System.out.println(numberChecker);
    }
}
