package Prac6;

import java.util.Random;

public class Main {

    public static void merge(Comparable[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        Comparable[] L = new Comparable[n1 + 1];
        Comparable[] R = new Comparable[n2 + 1];
        for (int i = 1; i <= n1; ++i) {
            L[i - 1] = a[p + i - 1];
        }
        for (int j = 1; j <= n2; j++) {
            R[j - 1] = a[q + j];
        }
        for (int i = 0, j = 0, k = p; k <= r; ++k) {
            if (i < n1 && j < n2) {
                if (L[i].compareTo(R[j]) <= 0) {
                    a[k] = L[i];
                    i++;
                }
                else {
                    a[k] = R[j];
                    j++;
                }
            }
            else if (i < n1) {
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
        }
    }
    public static void mergeSort(Comparable[] a, int p, int r) {
        int q;
        if (p < r) {
            q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }
    public static Student[] mergeTwoStudentArrays(Student[] a, Student[] b) {
        Student[] res = new Student[a.length + b.length];
        System.arraycopy(a, 0, res, 0, a.length);
        System.arraycopy(b, 0, res, a.length, b.length);
        merge(res, 0, a.length - 1, res.length - 1);
        return res;
    }
    public static void main(String[] args) {
        Random random = new Random();
        Student[] students1 = new Student[20];
        for(int i = 0; i < 20; ++i){
            String name = "";
            for(int j = 0; j < 5; ++j)
                name += (char)(random.nextInt(26) + 97);
            students1[i] = new Student(random.nextInt(100), name);
            System.out.println(students1[i]);
        }
        System.out.println();
        Student[] students2 = new Student[13];
        for(int i = 0; i < 13; ++i){
            String name = "";
            for(int j = 0; j < 7; ++j)
                name += (char)(random.nextInt(26) + 97);
            students2[i] = new Student(random.nextInt(100), name);
            System.out.println(students2[i]);
        }
        mergeSort(students1, 0, students1.length - 1);
        mergeSort(students2, 0, students2.length - 1);
        Student[] students = mergeTwoStudentArrays(students1, students2);
        System.out.println();
        for(int i = 0; i < students1.length + students2.length; ++i){
            System.out.println(i + " " + students[i]);
        }
    }
}