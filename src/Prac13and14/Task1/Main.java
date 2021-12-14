package Prac13and14.Task1;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date1 = new GregorianCalendar(2021, 11 - 1, 25).getTime();
        date1.setHours(19);
        date1.setMinutes(30);
        System.out.println("Shcheglov " + sdf.format(date1) + " " +  sdf.format(calendar.getTime()));
    }
}
