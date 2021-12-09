package Prac13and14.Task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date inputDate = null;
        boolean flag = true;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        while(flag) {
            String inputDateString = scanner.next();
            try {
                inputDate = sdf.parse(inputDateString);
                flag = false;
            }
            catch (ParseException e){
                System.out.println("Wrong date entered, try again");
            }
        }
        //  (inputDate.getSeconds() > (System.currentTimeMillis() / 1000) ? inputDate.getSeconds() < (System.currentTimeMillis() / 1000) ? 1 : 0 : -1)
        try {
            System.out.println("Input Date:" + inputDate.compareTo(sdf.parse(sdf.format(new Date(System.currentTimeMillis())))));
            System.out.println("Input Date:" + inputDate.compareTo(sdf.parse(sdf.format(new Date()))));
        } catch (ParseException e) {
            System.out.println("Somehting went wrong :(");
            e.printStackTrace();
        }
    }
}
