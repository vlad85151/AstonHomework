package ru.aston.hometask.chain;

import ru.aston.hometask.Student;

public class BooksValidator extends StudentValidator {

    @Override
    protected boolean check(Student student) {
        if (student.getBooks() == null || student.getBooks().size() < 5) {
            System.out.println("Ошибка: у студента должно быть минимум 5 книг.");
            return false;
        }

        return true;
    }
}