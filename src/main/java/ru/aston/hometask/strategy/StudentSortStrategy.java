package ru.aston.hometask.strategy;

import ru.aston.hometask.Student;

import java.util.List;

public interface StudentSortStrategy {

    List<Student> sort(List<Student> students);
}