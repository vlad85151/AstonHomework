package ru.aston.hometask.chain;

import ru.aston.hometask.Student;

public abstract class StudentValidator {

    private StudentValidator next;

    public StudentValidator setNext(StudentValidator next) {
        this.next = next;
        return next;
    }

    public boolean validate(Student student) {
        if (!check(student)) {
            return false;
        }

        if (next == null) {
            return true;
        }

        return next.validate(student);
    }

    protected abstract boolean check(Student student);
}