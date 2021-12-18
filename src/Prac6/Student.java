package Prac6;

public class Student implements Comparable<Student>{
    private Integer averageScore;
    private String name;

    public Student(Integer averageScore, String name) {
        this.averageScore = averageScore;
        this.name = name;
    }

    public Student() {
        averageScore = 100;
        name = "Unknown";
    }

    public Integer getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "averageScore=" + averageScore +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(averageScore > o.averageScore)
            return 1;
        if(averageScore == o.averageScore)
            return 0;
        if(averageScore < o.averageScore)
            return -1;
        return 0;
    }
}
