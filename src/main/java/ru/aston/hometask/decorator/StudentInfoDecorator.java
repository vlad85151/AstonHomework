package ru.aston.hometask.decorator;

import ru.aston.hometask.Student;
import ru.aston.hometask.Book;

public class StudentInfoDecorator implements StudentInfo {

    private final StudentInfo studentInfo;
    private final Student student;

    public StudentInfoDecorator(
            StudentInfo studentInfo,
            Student student
    ) {
        this.studentInfo = studentInfo;
        this.student = student;
    }

    @Override
    public String getInfo() {
        int bookCount = student.getBooks().size();

        int totalPages = student.getBooks()
                .stream()
                .mapToInt(Book::getPages)
                .sum();

        return studentInfo.getInfo()
                + "\nКоличество книг: " + bookCount
                + "\nВсего страниц: " + totalPages;
    }
}