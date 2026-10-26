package ru.aston.hometask.strategy;

import ru.aston.hometask.Student;

import java.util.Comparator;
import java.util.List;

public class SortByName implements StudentSortStrategy {

    @Override
    public List<Student> sort(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
    }
}