package org.example;

import java.util.UUID;

public class HocSinh {
    private String id;
    private String name;
    private int age;
    private double score;

    public HocSinh(String studentName, int studentAge, double studentMark) {
        this.id = "ID-"+ UUID.randomUUID().toString();
        this.name = studentName;
        this.age = studentAge;
        this.score = studentMark;
    }

    public void info() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Mark: " + score);
    }

    public static String rate(HocSinh hocSinh) {
        if (hocSinh.score < 0 || hocSinh.score > 10) {
            throw new IllegalArgumentException("Invalid Mark");
        }
        if (hocSinh.score < 5) {
            return "Yeu";
        } else if (hocSinh.score < 6.5) {
            return "Trung Binh";
        } else if (hocSinh.score < 8) {
            return "Kha";
        } else if (hocSinh.score < 9) {
            return "Gioi";
        } else {
            return "Xuat xac";
        }
    }
}
