package ru.aston.hometask.chain;

import ru.aston.hometask.Student;

import java.util.Set;

public class IdValidator extends StudentValidator {

    private final Set<Integer> existingIds;

    public IdValidator(Set<Integer> existingIds) {
        this.existingIds = existingIds;
    }

    @Override
    protected boolean check(Student student) {
        if (student.getId() <= 0) {
            System.out.println("Ошибка: ID должен быть положительным.");
            return false;
        }

        if (existingIds.contains(student.getId())) {
            System.out.println("Ошибка: студент с таким ID уже существует.");
            return false;
        }

        return true;
    }
}