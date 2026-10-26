package ru.aston.hometask.chain;

import ru.aston.hometask.Student;

public class AgeValidator extends StudentValidator {

    @Override
    protected boolean check(Student student) {
        if (student.getAge() < 16 || student.getAge() > 100) {
            System.out.println("Ошибка: возраст должен быть от 16 до 100 лет.");
            return false;
        }

        return true;
    }
}