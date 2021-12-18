package Prac5;

import java.util.Scanner;

public class Main {

    public static void rec1(int n){
        if(n > 1)
            rec1(n - 1);
        for(int i = 0; i < n; ++i) {
            System.out.print(n + " ");
        }
    }

    public static void rec2(int n){
        if(n > 1)
            rec2(n - 1);
        System.out.print(n + " ");
    }

    public static boolean rec8(String s){
        if(s.length() < 2)
            return true;
        if(s.charAt(0) == s.charAt(s.length() - 1))
            return rec8(s.substring(1, s.length() - 1));
        else
            return false;
    }

    public static void rec7(int n, int div)
    {
        if (n == 1) return;
        if (n % div == 0) {
            System.out.print(div + " ");
            rec7(n / div, div);
        }
        else if (div == 2)
            rec7(n, div + 1);
        else
            rec7(n, div + 2);
    }

    public static int rec5(int n){
        int sum = n % 10;
        if(n / 10 > 0)
            sum += rec5(n / 10);
        return sum;
    }

    public static void rec13(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n > 0) {
            int m = scanner.nextInt();
            System.out.println(n);
            if (m > 0) {
                rec13();
            }
        }
    }

    public static void rec14(int n){
        if(n / 10 > 0)
            rec14(n / 10);
        System.out.print(n % 10 + " ");
    }

    public static void rec15(int n){
        System.out.print(n % 10 + " ");
        if(n / 10 > 0)
            rec15(n / 10);
    }

    public static void main(String[] args) {
        rec1(6);
        System.out.println();
        rec2(10);
        System.out.println();
        System.out.println(rec8("ABOBA"));
        System.out.println(rec8("ABBO1OBBA"));
        System.out.println(rec8("ABOBUS"));
        rec7(1235, 2);
        System.out.println();
        rec7(46456, 2);
        System.out.println();
        System.out.println(rec5(11111));
        System.out.println(rec5(1234));
        rec13();
        rec14(123456);
        System.out.println();
        rec15(456789);
    }
}
