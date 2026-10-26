package ru.aston.hometask.builder;

import ru.aston.hometask.Book;
import ru.aston.hometask.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBuilder {

    private int id;
    private String name;
    private int age;
    private String faculty;
    private int admissionYear;
    private List<Book> books = new ArrayList<>();

    public StudentBuilder id(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder name(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder age(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder faculty(String faculty) {
        this.faculty = faculty;
        return this;
    }

    public StudentBuilder admissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
        return this;
    }

    public StudentBuilder books(List<Book> books) {
        this.books = books == null
                ? new ArrayList<>()
                : new ArrayList<>(books);
        return this;
    }

    public Student build() {
        return new Student(
                id,
                name,
                age,
                faculty,
                admissionYear,
                books
        );
    }
}