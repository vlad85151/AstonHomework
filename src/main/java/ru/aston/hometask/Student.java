package ru.aston.hometask;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private int age;
    private String faculty;
    private int admissionYear;
    private List<Book> books;

    public Student() {
        this.books = new ArrayList<>();
    }

    public Student(int id, String name, int age,
                   String faculty, int admissionYear,
                   List<Book> books) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.faculty = faculty;
        this.admissionYear = admissionYear;
        this.books = books == null
                ? new ArrayList<>()
                : new ArrayList<>(books);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public void setBooks(List<Book> books) {
        this.books = books == null
                ? new ArrayList<>()
                : new ArrayList<>(books);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", faculty='" + faculty + '\'' +
                ", admissionYear=" + admissionYear +
                ", books=" + books +
                '}';
    }
}