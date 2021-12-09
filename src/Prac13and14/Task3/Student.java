package Prac13and14.Task3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    String name = "";
    int age = 0;
    Date dateOfBirth = new Date(0);

    public Student(String name, int age, Date dateOfBirth) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public String toString(String dateFormat) {
        return "Student {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + (new SimpleDateFormat(dateFormat)).format(dateOfBirth) +
                '}';
    }
}
