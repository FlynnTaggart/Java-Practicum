package Prac13and14.Task4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        StringBuilder t = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s1, "[<>]");
        try {
            if (st.countTokens() != 3) {
                throw new Exception("Wrong input");
            }
        }
        catch (Exception e){
            System.out.print(e);
        }
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(s2, "[<>]");
        try {
            if (st.countTokens() != 2) {
                throw new Exception("Wrong input");
            }
        }
        catch (Exception e){
            System.out.print(e);
        }
        int hours = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        Date date = new GregorianCalendar(year, month - 1, day).getTime();
        date.setHours(hours);
        date.setMinutes(minutes);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy hh:mm");
        System.out.print(sdf.format(date));
    }
}
