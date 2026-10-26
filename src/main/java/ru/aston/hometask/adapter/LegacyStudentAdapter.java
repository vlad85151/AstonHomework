package ru.aston.hometask.adapter;

import ru.aston.hometask.Student;
import ru.aston.hometask.builder.StudentBuilder;

import java.util.ArrayList;

public class LegacyStudentAdapter implements StudentDataAdapter {

    @Override
    public Student adapt(LegacyStudentRecord record) {
        return new StudentBuilder()
                .id(record.getStudentNumber())
                .name(record.getFullName())
                .age(record.getStudentAge())
                .faculty(record.getDepartment())
                .admissionYear(record.getYearOfAdmission())
                .books(new ArrayList<>())
                .build();
    }
}