package ru.aston.hometask.chain;

import ru.aston.hometask.Student;

public class NameValidator extends StudentValidator {

    @Override
    protected boolean check(Student student) {
        if (student.getName() == null || student.getName().isBlank()) {
            System.out.println("Ошибка: имя студента не указано.");
            return false;
        }

        return true;
    }
}