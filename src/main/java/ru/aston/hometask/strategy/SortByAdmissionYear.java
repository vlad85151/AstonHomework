package ru.aston.hometask.strategy;

import ru.aston.hometask.Student;

import java.util.Comparator;
import java.util.List;

public class SortByAdmissionYear implements StudentSortStrategy {

    @Override
    public List<Student> sort(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::getAdmissionYear))
                .toList();
    }
}