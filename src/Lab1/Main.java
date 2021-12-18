package Lab1;

import java.util.Scanner;

public class Main {

    public static long factor(long x){
        long n = 2;
        for(int i = 3; i <= x; ++i){
            n *= i;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        System.out.println(factor(x));
    }
}
