package Prac13and14.Task3;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Flynn", 54, new Date());
        System.out.println(student.toString("dd.MM.yyyy"));
        System.out.println(student.toString("dd/MM/yyyy"));
        System.out.println(student.toString("dd MMMM yyyy"));
    }
}
